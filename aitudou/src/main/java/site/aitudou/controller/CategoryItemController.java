package site.aitudou.controller;

import site.aitudou.model.domain.Category;
import site.aitudou.model.domain.CategoryItem;
import site.aitudou.config.security.AnyUser;
import site.aitudou.service.CategoryService;
import site.aitudou.service.CategoryItemService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
@Controller
public class CategoryItemController {

	@Autowired
	private CategoryItemService itemService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/user/item/{id}", method = RequestMethod.GET)
	public String list(@AuthenticationPrincipal AnyUser user, @PathVariable("id") Long id, Model model) {
		List<CategoryItem> items = itemService.list(id, user.getId());	

		Category category = categoryService.getById(id, user.getId());
		model.addAttribute("user", user);
		model.addAttribute("category", category);
		model.addAttribute("items", items);
		return "items";
	}
}
