package edu.ssstoyanov.webserver.Repository;

import edu.ssstoyanov.webserver.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean findByLogin(String login);

    boolean findByLoginAndPassword(String login, String password);
}
