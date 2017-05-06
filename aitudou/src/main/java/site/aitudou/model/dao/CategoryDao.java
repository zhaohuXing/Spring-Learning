package site.aitudou.model.dao;

import site.aitudou.model.domain.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface CategoryDao {

	@Select("select * from category where user_id = #{userId}")
	List<Category> selectByUserId(@Param("userId") Long userId); 

	@Insert("insert into category(user_id, name, logo, md5)values(#{userId}, #{name}, #{logo}, #{md5})")
	int insert(Category category);

	@Delete("delete from category where id = #{id} and user_id = #{userId}")
	int delete(@Param("id") Long id, @Param("userId") Long userId);

	@Update("update category set amount = amount + 1 where id = #{id}")
	int addAmountById(@Param("id") Long id);

	@Select("select * from category where id = #{id} and user_id = #{userId}")
	Category selectByIdAndUserId(@Param("id") Long id, @Param("userId") Long userId);

	@Update("UPDATE category SET `amount` = `amount` - 1 WHERE `id` = #{id}")
	int reduceAmountById(@Param("id") Long id);

}
