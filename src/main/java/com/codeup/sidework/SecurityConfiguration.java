package com.codeup.sidework;

import com.codeup.sidework.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            /* Login configuration */
                .formLogin()
                .loginPage("/users/login-worker")
                .defaultSuccessUrl("/users/workspace-worker") // user's home page, it can be any URL
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login-worker?logout") // append a query string value
            /* Pages that can be viewed without having to log in */
                .and()
                .authorizeRequests()
                .antMatchers(
//                        "/listings", // anyone can see the job listing pages
                        "/users", "/users/register-mgmt", "/users/register-worker", "/users/login-worker")
                // anyone can see the homepage, login & register pages,
                // and view all users without being signed in
                // -- check with Michael
                .permitAll()
            /* Pages that require authentication */
                .and()
                .authorizeRequests()
                .antMatchers(
//                        "/listings/create",  // only authenticated users can create ads
//                        "/listings/edit", // only authenticated users can create ads
                        "/users/workspace-mgmt", "/users/workspace-worker",
                        "/users/{id}/edit" // only authenticated users can edit their profile
                )
                .authenticated()
        ;
    }
}
