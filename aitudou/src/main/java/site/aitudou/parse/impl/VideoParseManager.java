package site.aitudou.parse.impl;

import com.alibaba.fastjson.JSONObject;
import site.aitudou.dto.Video;
import site.aitudou.parse.Parser;
import site.aitudou.parse.ParseManager;
import site.aitudou.parse.video.Letv;
import site.aitudou.util.UrlUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Service
@Log4j
public class VideoParseManager implements ParseManager {
	
	@Autowired
	private StringRedisTemplate redisTemplate;

	private Map<String, Parser> parserMap;

	public VideoParseManager() {
		parserMap = new HashMap<>();
		parserMap.put("le.com", new Letv());
	}

	@Override
	public Parser getVideoParse(String key) {
		return parserMap.get(key); 
	}

	@Override
	public Video parseVideo(String url) {
		String cacheValue = redisTemplate.opsForValue().get(url);
		Video video;
		if (StringUtils.isEmpty(cacheValue)) {
			log.info("Parse:" + url);
			String key = UrlUtil.getTopDomain(url);
			Parser videoParse = this.getVideoParse(key);
			video = (Video)videoParse.parse(url);
			this.cacheVideoInfo(url, video);
		} else {
			log.info("Get cache info :" + url);
			video = JSONObject.parseObject(cacheValue, Video.class);
		}
		log.debug("VIDEO:" + JSONObject.toJSONString(video));
		return video;
	}

	@Async
	private void cacheVideoInfo(String url, Video video) {
		if (StringUtils.isNotEmpty(video.getPlayUrl())) {
			log.info("Cache video: " + url);
			String value = JSONObject.toJSONString(video);
			redisTemplate.opsForValue().set(url, value);
			redisTemplate.expire(url, 3, TimeUnit.HOURS);
		}
	}
}
