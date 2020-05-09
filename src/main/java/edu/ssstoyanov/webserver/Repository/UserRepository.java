package edu.ssstoyanov.webserver.Repository;

import edu.ssstoyanov.webserver.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Stanislav Stoianov
 * @version 1.4
 * @apiNote the Hibernate class used to store user data is controlled using Spring Security
 * @see edu.ssstoyanov.webserver.Service.UserService
 * @see User
 * @see edu.ssstoyanov.webserver.Service.UserHandlingService
 * @since 10/04/20
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}