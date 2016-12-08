package H5Editor.Service;

import H5Editor.Model.Admin;
import H5Editor.Model.AdminRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrCJ on 2016/12/8.
 */
public class AdminUserService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public AdminUserService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(
                    admin.getUsername(),
                    admin.getPassword(),
                    authorities
            );
        }
        throw new UsernameNotFoundException(
                "Admin '" + username + "' not found"
        );
    }
}
