package edu.ssstoyanov.webserver.Controller;

/**
 * Класс для работы с вебом
 */

import edu.ssstoyanov.webserver.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ssstoyanov.webserver.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Stanislav Stoianov
 * creation date: 17/04/20.
 * @since 1.0
 */
@Controller
public class AuthController {

    // FIXME: 01.05.2020 
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/signin")
    public String signIn(Model model, @RequestParam String login, @RequestParam String password) {
        // TODO: 01.05.2020  
        return "";
    }

    @RequestMapping("/signup")
    public String signUp(Model model, @RequestParam String login, @RequestParam String password) {
        // TODO: 01.05.2020
        return "";
    }
}
