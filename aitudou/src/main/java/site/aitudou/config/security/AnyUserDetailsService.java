package site.aitudou.config.security;

import site.aitudou.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service; 

/**
 * 自定义UserDetailsService
 * Create by sprint on 2017/04/01.
 */
@Service
class AnyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
									throws UsernameNotFoundException {
		site.aitudou.model.domain.User user = userService.getByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		AnyUser anyUser = new AnyUser(username, user.getPassword(), authorities);
		anyUser.setId(user.getId());
		anyUser.setNickname(user.getNickname());
		return anyUser;
	}
}
