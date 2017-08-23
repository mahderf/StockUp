package com.stockup.group;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .authorizeRequests()
                // allow anyone to access default route, home, both purchase pages
                .antMatchers("/", "/home", "/purchaseproduct", "/purchaseproductconfirmation",
                        "/css/**", "/js/**", "/img/**", "/scss/**", "/vendor/**").permitAll() // to allow css and js files to work, could also add img folders, etc
                .anyRequest().authenticated() // after authentication, all routes will be accessible

                // below: this just points to the page that will SHOW when user tries to access any route that requires auth
                // after successful login, they will automatically continue to whatever link they clicked to trigger the auth form
                .and().formLogin().loginPage("/login").permitAll()
                .and().httpBasic() // allows authentication in the URL itself
                // logout via httprequest, not very secure but ok for now
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home");;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().
                withUser("admin").password("password").roles("USER");

                // to add more accounts, chain more
//                .and().withUser("userTwo").password("passwordTwo").roles("USER");


    }

}