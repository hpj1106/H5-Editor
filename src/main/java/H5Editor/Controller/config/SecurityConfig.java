package H5Editor.Controller.config;

import H5Editor.Model.UserRepository;
import H5Editor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by MrCJ on 2016/12/8.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/user/*").access("hasRole('USER')")
                .antMatchers("/admin/*").access("hasRole('ADMIN')")
                .antMatchers("/systemAdmin/*").access("hasRole('SYSTEM')")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserService(userRepository));
        auth.inMemoryAuthentication()
                .withUser("H5Editor").password("123456").roles("SYSTEM");
    }
}
