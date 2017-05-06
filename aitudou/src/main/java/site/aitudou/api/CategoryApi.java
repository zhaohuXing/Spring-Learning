package site.aitudou.api;

import site.aitudou.config.security.AnyUser;
import site.aitudou.service.CategoryService;
import site.aitudou.dto.SimpleResponse;
import site.aitudou.model.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
public class CategoryApi {

	@Autowired
	private CategoryService service;
	@RequestMapping(value = "/user/category/add", method = RequestMethod.POST)
	public SimpleResponse addCategory(@AuthenticationPrincipal AnyUser user, HttpServletRequest request) {
		SimpleResponse response = new SimpleResponse();
		String name = request.getParameter("name");
		if (name == null || name.trim().equals("")) {
			response.setCode(200);
			return response;
		}
		
		if (service.insert(user.getId(), name)) {
			response.setCode(100);
			return response;
		}
		response.setCode(200);
		return response;
	}

	@RequestMapping(value = "/user/category/delete/{categoryId}", method = RequestMethod.GET)
	public SimpleResponse deleteCategory(@AuthenticationPrincipal AnyUser user, @PathVariable("categoryId") Long categoryId) {
		SimpleResponse simpleResponse = new SimpleResponse();
		System.out.println("testsssss");
		if (service.deleteByUserIdAndId(user.getId(), categoryId)) {
			simpleResponse.setCode(100);
			return simpleResponse;
		}
		simpleResponse.setCode(200);
		return simpleResponse;
	}

	@RequestMapping(value = "/user/categories", method = RequestMethod.GET)
	public List<Category> list(@AuthenticationPrincipal AnyUser user) {
		return service.getByUserId(user.getId()); 
	}
}
