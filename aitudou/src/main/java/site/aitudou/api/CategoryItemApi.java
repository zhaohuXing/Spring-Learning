package site.aitudou.api;

import com.alibaba.fastjson.JSONObject;
import site.aitudou.config.security.AnyUser;
import site.aitudou.model.domain.CategoryItem;
import site.aitudou.dto.SimpleResponse; 
import site.aitudou.service.CategoryItemService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j
public class CategoryItemApi {
	
	@Autowired
	private CategoryItemService service;


	@RequestMapping(value = "/user/category/item/add", method = RequestMethod.POST)
	public SimpleResponse add(@AuthenticationPrincipal AnyUser user, HttpServletRequest request) {
		SimpleResponse response = new SimpleResponse();
		CategoryItem item = createItem(user.getId(), request);
		if (service.insert(item)) {
			response.setCode(100);
			response.setMessage("私藏成功, 请到对应分类下查看!");
			return response;
		}
		log.error("操作失败, CategoryItem:" + JSONObject.toJSONString(item));
		response.setCode(200);
		response.setMessage("私藏成功");
		return response;
	}

	private CategoryItem createItem(Long userId, HttpServletRequest request) {
		CategoryItem item = new CategoryItem();
		item.setUserId(userId);
		String name = request.getParameter("name");
		item.setName(name);
		String image = request.getParameter("image");
		item.setImage(image);
		String url = request.getParameter("value");
		item.setUrl(url);
		String type = request.getParameter("type");
		item.setType(type);
		Long categoryId = Long.valueOf(request.getParameter("id"));
		item.setCategoryId(categoryId);
		return item;
	}

	@RequestMapping(value = "/user/category/item/delete/{id}", method = RequestMethod.GET)
	public SimpleResponse delete(@AuthenticationPrincipal AnyUser user, @PathVariable("id") Long id) {
		SimpleResponse response = new SimpleResponse();
		if (service.delete(id, user.getId())) {
			response.setCode(100);
			return response;
		}
		log.error("操作失败,userId:" + user.getId() + ", CategoryItemId:" + id );
		response.setCode(200);
		return response;
	}
}
