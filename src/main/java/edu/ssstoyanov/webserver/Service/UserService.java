package edu.ssstoyanov.webserver.Service;

import edu.ssstoyanov.webserver.Model.User;
import edu.ssstoyanov.webserver.Repository.RoleRepository;
import edu.ssstoyanov.webserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author Stanislav Stoianov
 * @version 1.4
 * @see User
 * @see edu.ssstoyanov.webserver.Repository.UserRepository
 * @see edu.ssstoyanov.webserver.Service.UserHandlingService
 * @since 10/04/20
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Collections.singletonList(roleRepository.findByRole("USER"))));
        return userRepository.save(user);
    }

}