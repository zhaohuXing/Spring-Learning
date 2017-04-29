package com.sprint.api;

import com.sprint.model.domain.Episode;
import com.sprint.dto.Video;
import com.sprint.parse.ParseManager;
import com.sprint.parse.Parser;
import com.sprint.util.UrlUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class VideoApi {
	
	@Autowired
	private ParseManager parseManager;
	@RequestMapping("/api/video")
	public Video play(HttpServletRequest request) {
		String url = request.getParameter("v");
		url = url.replaceAll("\\?(spm|from).*", "");
		return parseManager.parseVideo(url);
	}

	@RequestMapping("/api/episode")
	public List<Episode> episodes(HttpServletRequest request) {
		String url = request.getParameter("v");
		url = url.replaceAll("\\?(spm|from).*", "");
		String key = UrlUtil.getTopDomain(url);
		Parser videoParse = parseManager.getVideoParse(key);
		return videoParse.parseEpisodes(url);
	}
}
