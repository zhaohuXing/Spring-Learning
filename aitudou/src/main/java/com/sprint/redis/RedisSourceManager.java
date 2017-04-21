package com.sprint.redis;

import com.alibaba.fastjson.JSONObject;
import com.sprint.dto.VideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
/*
 * 视频资源管理器
 */
@Component
public class RedisSourceManager {
	public final String VIDEO_PREFIX_HOME_CAROUSEL_KEY = "HOME_VIDEO_CAROUSEL";	
	public final String VIDEO_PREFIX_HOME_RECOMMEND_KEY = "HOME_VIDEO_RECOMMEND";
	public final String VIDEO_PREFIX_HOME_TV_KEY = "HOME_VIDEO_TV";
	public final String VIDEO_PREFIX_HOME_TV_HOT_KEY = "HOME_VIDEO_TV_HOT";
	public final String VIDEO_PREFIX_HOME_MOVIE_KEY = "HOME_VIDEO_MOVIE";
	public final String VIDEO_PREFIX_HOME_CARTOON_KEY = "HOME_VIDEO_CARTOON";
	public final String VIDEO_PREFIX_HOME_CARTOON_HOT_KEY = "HOME_VIDEO_CARTOON_HOT";
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public List<VideoDTO> getVideosByKeyAndTag(String key, String tag) {
		key = key + "_" + tag;
		String cacheValue = stringRedisTemplate.opsForValue().get(key);
		return JSONObject.parseArray(cacheValue, VideoDTO.class);
	}

	public void saveVideos(String key, List<VideoDTO> videos) {
		String value = JSONObject.toJSONString(videos);
		stringRedisTemplate.opsForValue().set(key, value);
	}

}

