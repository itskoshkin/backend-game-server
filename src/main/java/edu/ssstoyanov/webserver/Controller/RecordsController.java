package edu.ssstoyanov.webserver.Controller;

import edu.ssstoyanov.webserver.Model.User;
import edu.ssstoyanov.webserver.Repository.UserRepository;
import edu.ssstoyanov.webserver.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @author Stanislav Stoianov
 * @since 19/04/20
 * @version 1.4
 */

@Controller
public class RecordsController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RecordService recordService;

    @GetMapping(value = "/records")
    public ModelAndView records() {
        ModelAndView modelAndView = new ModelAndView();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        HashMap<String, Long> data = recordService.getRecordsByUser(user);
        modelAndView.addObject("data", data);
        modelAndView.setViewName("records");
        return modelAndView;
    }

}
