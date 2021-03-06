package site.aitudou.controller;

import site.aitudou.dto.Video;
import site.aitudou.parse.ParseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
@Controller
public class VideoController {

	@Autowired
	private ParseManager parseManager;

	 /* 视频播放页 */
	@RequestMapping(value = "/play", method = RequestMethod.GET)
  	public String play(HttpServletRequest request, Model model){
		String url = request.getParameter("v");
    	url = url.replaceAll("\\?(spm|from).*" , "");
		Video video = parseManager.parseVideo(url);
   		model.addAttribute("video", video);
		System.out.println("视频地址:" + video.getPlayUrl());
    	return "play-h5";
  	}

}
