package edu.ssstoyanov.webserver.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Stanislav Stoianov
 * @version 1.0
 * @apiNote the Hibernate class used to distinguish access by role, controlled using Spring Security
 * @see edu.ssstoyanov.webserver.Repository.RoleRepository
 * @see edu.ssstoyanov.webserver.Config.WebSecurityConfiguration
 * @see edu.ssstoyanov.webserver.Config.SecurityConfiguration
 * @since 10/04/20
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;
}
