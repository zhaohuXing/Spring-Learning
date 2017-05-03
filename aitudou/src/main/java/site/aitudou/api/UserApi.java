package site.aitudou.api;

import site.aitudou.config.security.AnyUser;
import site.aitudou.model.domain.User;
import site.aitudou.service.UserService;
import site.aitudou.dto.SimpleResponse;
import site.aitudou.util.CheckUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserApi {
	
	@Autowired
	private UserService service;


	@RequestMapping(value = "/user/name", method = RequestMethod.POST)
	public SimpleResponse updateUserInfo(@AuthenticationPrincipal AnyUser user, HttpServletRequest request) {
		SimpleResponse response = new SimpleResponse();
		String nickname = request.getParameter("nickname");
		if (!CheckUtil.checkNickname(nickname)) {
			response.setCode(200);
			response.setMessage("修改失败, 参数不正确");
			return response;
		}
		System.out.println(user.getId() + ":" + nickname );

		if (service.updateNickname(user.getId(), nickname)) {
			System.out.println("执行了?");
			response.setCode(100);
			return response;
		}

		response.setCode(200);
		response.setMessage("修改失败, 参数不正确");
		return response;

	}
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public SimpleResponse signUp(HttpServletRequest request) {
		User user = createUser(request);
		SimpleResponse response = checkSignUpRequest(user);
		if (response.getCode() == 100) {
			if (!service.signUp(user)) {
				response.setCode(200);
				response.setMessage("此邮箱已注册，请勿重复注册！");
				return response;
			} else {
				response.setMessage("注册激活邮件已发送至您的邮箱，请在12小时内激活完成注册！");
				return response;
			}
		}
		return response;
	}
	
	private User createUser(HttpServletRequest request) {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setNickname(request.getParameter("nickname"));
		return user;
	}

	private SimpleResponse checkSignUpRequest(User user) {
		SimpleResponse response = new SimpleResponse();
		String email = user.getEmail();
		if (!CheckUtil.checkEmail(email)) {
			response.setCode(200);
			response.setMessage("邮箱格式不合格");
			return response;
		}

		String password = user.getPassword();
		if (!CheckUtil.checkPassword(password)) {
			response.setCode(200);
			response.setMessage("密码长度必须为8-16位，且必须包含数字和字母");
			return response;
		}

		String nickname = user.getNickname();
		if (!CheckUtil.checkNickname(nickname)) {
			response.setCode(200);
			response.setMessage("昵称长度不合法");
			return response;
		}
		response.setCode(100);
		return response;
	}
}
