package edu.ssstoyanov.webserver.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @apiNote class for encrypting passwords in a database
 * @author Stanislav Stoianov
 * @since 13/04/20.
 * @version 1.0
 */

@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
