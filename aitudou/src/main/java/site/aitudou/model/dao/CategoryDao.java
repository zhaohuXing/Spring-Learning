package site.aitudou.model.dao;

import site.aitudou.model.domain.Category;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import java.util.List;
@Mapper
public interface CategoryDao {

	@Select("select * from category where user_id = #{userId}")
	List<Category> selectByUserId(@Param("userId") Long userId); 

	@Insert("insert into category(user_id, name, logo, md5)values(#{userId}, #{name}, #{logo}, #{md5})")
	int insert(Category category);
}
