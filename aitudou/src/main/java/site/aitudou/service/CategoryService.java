package site.aitudou.service;

import site.aitudou.model.domain.Category;
import site.aitudou.model.dao.CategoryDao;
import site.aitudou.model.dao.CategoryItemDao;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Log4j
public class CategoryService {
	
	private static final String LOGO = "/image/category/%s.jpg";

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private CategoryItemDao itemDao;

	@Transactional
	public boolean deleteByUserIdAndId(Long userId, Long id) {
		if (categoryDao.delete(id, userId) != 0) {
			itemDao.deleteCategory(id, userId);
			return true;
		}
		return false;
		
	}

	public List<Category> getByUserId(Long userId) {
		List<Category> categories = categoryDao.selectByUserId(userId);
		if (categories == null) {
			return new ArrayList<>();
		}
		return categories;
	}

	public boolean insert(Long userId, String name) {
		Category category = new Category();
		category.setName(name);
		category.setUserId(userId);
		String md5 = generateMD5(userId, name);
		category.setMd5(md5);
		String logo = generateLogo();
		category.setLogo(logo);
		return categoryDao.insert(category) > 0;
	}

	private String generateMD5(Long userId, String name) {
		Long time = new Date().getTime();
		byte[] bytes = (time + userId + name).getBytes();
		return DigestUtils.md5DigestAsHex(bytes);
	}

	private String generateLogo() {
		String random = String.valueOf(RandomUtils.nextInt(10));
		return String.format(LOGO, random);
	}	


}
