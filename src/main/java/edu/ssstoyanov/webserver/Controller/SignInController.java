package edu.ssstoyanov.webserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Stanislav Stoianov
 * @since 14/04/20
 * @version 1.3
 */

@Controller
public class SignInController {

    @GetMapping(value = "/signin")
    public ModelAndView signin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");
        return modelAndView;
    }

}