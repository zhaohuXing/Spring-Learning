package site.aitudou.dao.service;

import site.aitudou.model.domain.Category;
import site.aitudou.model.dao.CategoryDao;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
@Log4j
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	public List<Category> getByUserId(Long userId) {
		List<Category> categories = categoryDao.selectByUserId(userId);
		if (categories == null) {
			return new ArrayList<>();
		}
		return categories;
	}


}