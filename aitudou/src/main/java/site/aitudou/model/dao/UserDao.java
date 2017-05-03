package site.aitudou.model.dao;

import site.aitudou.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;



@Mapper
public interface UserDao {
	
	@Select("select * from user where email = #{email}")
	User selectByEmail(@Param("email") String email);

	@Insert("insert into user(email, password, nickname) values(#{email}, #{password}, #{nickname})")
	int insert(User user);

	@Update("update user set nickname = #{nickname} where id = #{id}")
	int updateNicknameById(@Param("id") Long id, @Param("nickname") String nickname);
}
