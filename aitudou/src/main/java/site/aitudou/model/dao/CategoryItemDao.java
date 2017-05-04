package site.aitudou.model.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryItemDao {
	
	@Delete("delete from category_item where category_id = #{categoryId} and user_id = #{userId}")
	int deleteCategory(@Param("categoryId") Long categoryId, @Param("userId") Long userId);
}
