package edu.ssstoyanov.webserver.Rest;

/**
 * класс для работы с играми посредством API
 */


import edu.ssstoyanov.webserver.Model.User;
import edu.ssstoyanov.webserver.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetController {

    private final UserRepository userRepository;

    public GetController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/get")
    public List<User> doGet(){
        return userRepository.findAll();
    }

    @PutMapping("put")
    public void doPut() {

    }

    @PostMapping
    public void doPost(){

    }

    @DeleteMapping
    public void doDelete(){

    }

}
