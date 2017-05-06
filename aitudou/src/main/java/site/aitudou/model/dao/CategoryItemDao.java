package site.aitudou.model.dao;

import site.aitudou.model.domain.CategoryItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface CategoryItemDao {
	
	@Delete("delete from category_item where category_id = #{categoryId} and user_id = #{userId}")
	int deleteCategory(@Param("categoryId") Long categoryId, @Param("userId") Long userId);

	@Insert("insert into category_item (user_id, category_id, type, name, image, url) values(#{userId}, #{categoryId}, #{type}, #{name}, #{image}, #{url})")
	int insert(CategoryItem categoryItem);

	@Select("select * from category_item where category_id = #{categoryId} and user_id = #{userId}")
	List<CategoryItem> selectByCategoryIdAndUserId(@Param("categoryId") Long categoryId, @Param("userId") Long userId);

	@Delete("delete from category_item where id = #{id} and user_id = #{userId}")
	int delete(@Param("id") Long id, @Param("userId") Long userId);

	@Select("select category_id from category_item where id = #{id} and user_id = #{userId}")
	Long getCategoryIdByIdAndUserId(@Param("id") Long id, @Param("userId") Long userId);
 }
