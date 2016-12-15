package H5Editor.Service;

import H5Editor.Model.User;
import H5Editor.Model.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/8.
 */
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository adminRepository) {
        this.userRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            if (user.getType() == 0) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        authorities
                );
            }
            if (user.getType() == 1) {
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
