package edu.ssstoyanov.webserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Stanislav Stoianov
 * @since 18/04/20
 * @version 1.0
 */

@Controller
public class GamesController {

    @GetMapping(value = "/games")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("games");
        return modelAndView;
    }
}
