package site.aitudou.model.dao;

import site.aitudou.model.domain.Category;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface CategoryDao {

	@Select("select * from category where user_id = #{userId}")
	List<Category> selectByUserId(@Param("userId") Long userId); 
}
