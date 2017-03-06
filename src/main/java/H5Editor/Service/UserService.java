package H5Editor.Service;

import H5Editor.Model.User.User;
import H5Editor.Model.User.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/8.
 * 权限逻辑
 */
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名在数据库中查找User
        User user = userRepository.findByUsername(username);
        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            // 管理员
            if (user.getType() == 0 && user.isAvailable()) {
                // 增加Admin权限
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        authorities
                );
            }
            // 普通用户
            if (user.getType() == 1 && user.isAvailable()) {
                // 增加User权限
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        authorities
                );
            }

        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found"
        );
    }
}
