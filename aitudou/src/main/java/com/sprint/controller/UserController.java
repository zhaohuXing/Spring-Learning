package com.sprint.controller;

import com.sprint.dao.model.Category;
import com.sprint.dao.model.User;
import com.sprint.dao.service.CategoryService;
import com.sprint.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/validate/{token}", method = RequestMethod.GET)
	public String emailConfirm(@PathVariable("token") String token, Model model) {
		User user = userService.completeSignUp(token);
		if (user != null) {
			model.addAttribute("email", user.getEmail());
			model.addAttribute("result", "注册成功，赶快登录体验吧！");
		} else {
			model.addAttribute("result", "链接已失效, 请重新注册！");
		}
		return "login";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String email = ((UserDetails)principal).getUsername();
			User user = userService.getByEmail(email);
			model.addAttribute("user", user);
			List<Category> categories = categoryService.getByUserId(user.getId());
			model.addAttribute("categories", categories);
		}
		return "user";
	}
}
