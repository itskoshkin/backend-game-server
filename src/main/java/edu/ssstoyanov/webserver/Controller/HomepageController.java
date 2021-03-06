package edu.ssstoyanov.webserver.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Stanislav Stoianov
 * @version 2.0
 * @since 16/04/20
 */

@Controller
public class HomepageController {

    @GetMapping(value = "/main")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping(value = "/homepage")
    public ModelAndView homepage() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("user_name", auth.getName());
        modelAndView.setViewName("homepage");
        return modelAndView;
    }

    @GetMapping(value = "/admin")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("adminMessage", "Страница для администратора");
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping(value = "/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

}
