package edu.ssstoyanov.webserver.Config;

import edu.ssstoyanov.webserver.Service.UserHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @apiNote class for configuring web application protection
 * @author Stanislav Stoianov
 * @since 13/04/20
 * @version 1.6
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserHandlingService userHandlingService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userHandlingService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/main", "/signin", "/signup", "/error").permitAll()
                .antMatchers("/homepage/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/signin").failureUrl("/signin?error=true")
                .defaultSuccessUrl("/homepage", true)
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")
                    .logoutSuccessUrl("/signin?logout=true")
                    .invalidateHttpSession(true)
                    .permitAll()
                .and()
                    .exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/fonts/**", "/icons/**", "/js/**", "/vendor/**");
    }

}