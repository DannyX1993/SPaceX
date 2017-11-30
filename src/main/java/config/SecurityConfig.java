package config;

import api.Uris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(Uris.SERVLET_MAP + Uris.VERSION + Uris.USERS).access("hasRole('ROLE_USER')")
                .antMatchers(Uris.SERVLET_MAP + Uris.VERSION + Uris.USERS + Uris.USERS_VERSION).access("hasRole('ROLE_USER')")
                .antMatchers(Uris.SERVLET_MAP + Uris.VERSION + "/**").permitAll()
                .and().formLogin();

    }
}
