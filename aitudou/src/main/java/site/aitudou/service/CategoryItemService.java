package site.aitudou.service;

import site.aitudou.model.domain.enumclass.CategoryItemType;
import site.aitudou.model.domain.CategoryItem;
import site.aitudou.model.dao.CategoryDao;
import site.aitudou.model.dao.CategoryItemDao;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j
public class CategoryItemService {
	
	@Autowired
	private CategoryItemDao dao;

	@Autowired
	private CategoryDao categoryDao;

	private Map<String, String> defaultImages;

	public CategoryItemService() {
		defaultImages = new HashMap<>();
		defaultImages.put(CategoryItemType.VIDEO.name(), "item-video.jpg");
		defaultImages.put(CategoryItemType.ARTICLE.name(), "item-article.jpg");
	}

	@Transactional
	public boolean insert(CategoryItem item) {
		if (categoryDao.selectByIdAndUserId(item.getCategoryId(), item.getUserId()) == null) {
			return false;
		}

		String image = item.getImage();
		if (StringUtils.isEmpty(image)) {
			String type = item.getType();
			image = defaultImages.get(type);
			item.setImage(image);
		}
		
		if (dao.insert(item) > 0) {
			categoryDao.addAmountById(item.getCategoryId());
			return true;
		}
		return false;

	}

	public List<CategoryItem> list(Long categoryId, Long userId) {
		List<CategoryItem> items = dao.selectByCategoryIdAndUserId(categoryId, userId);
		if (items != null) {
			return items;
		}
		return new ArrayList<>();
	}

	@Transactional
	public boolean delete(Long id, Long userId) {
		Long categoryId = dao.getCategoryIdByIdAndUserId(id, userId); 
		if (dao.delete(id, userId) > 0) {
			categoryDao.reduceAmountById(categoryId);			
			return true;
		}
		return false;
	}
}
