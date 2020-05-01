package edu.ssstoyanov.webserver.Config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/signup").setViewName("signup");


    }
}
