package com.sprint.dao.service;

import com.sprint.model.domain.Category;
import com.sprint.model.dao.CategoryDao;
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
