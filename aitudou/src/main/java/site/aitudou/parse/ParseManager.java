package site.aitudou.parse;

import site.aitudou.dto.Video;
public interface ParseManager {
	
	/**
	 * 依据key获取对应的视频解析器
	 * @param key 一般为url的顶级域名
	 * @return 解析器
	 */
	Parser getVideoParse(String key);

	/**
	 * 从 url 中解析视频信息
	 * @param url 视频地址
	 * @return 视频信息 
	 */
	Video parseVideo(String url);
}
