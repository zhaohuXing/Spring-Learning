package site.aitudou.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;
public class AnyUser extends User {
	private Long id;
	private String nickname;

	public AnyUser (String username, String password, 
				Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public AnyUser (String username, String password,
					boolean enabled, boolean accountNonExpired,
					boolean credentialsNonExpired, boolean accountNonLocked,
					Collection<? extends GrantedAuthority> authorities      ) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	} 

	public String getNickname() {
		return nickname;
	}

}
