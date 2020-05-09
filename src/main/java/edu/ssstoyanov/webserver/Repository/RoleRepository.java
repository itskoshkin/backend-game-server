package edu.ssstoyanov.webserver.Repository;

import edu.ssstoyanov.webserver.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Stanislav Stoianov
 * @version 1.0
 * @see Role
 * @see edu.ssstoyanov.webserver.Config.WebSecurityConfiguration
 * @see edu.ssstoyanov.webserver.Config.SecurityConfiguration
 * @since 10/04/20
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}