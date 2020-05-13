package edu.ssstoyanov.webserver.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

/**
 * @author Stanislav Stoianov
 * @version 1.4
 * @apiNote the Hibernate class used to store user data is controlled using Spring Security
 * @see edu.ssstoyanov.webserver.Service.UserService
 * @see edu.ssstoyanov.webserver.Repository.UserRepository
 * @see edu.ssstoyanov.webserver.Service.UserHandlingService
 * @since 10/04/20
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    @Length(min = 5, max = 32, message = "Имя пользователя должно быть диапазоне от 5 до 32 символов")
    @NotEmpty(message = "Пожалуйста, введите имя пользователя")
    private String username;
    @Column(name = "password")
    @Length(min = 5, message = "Пароль должен состоять хотя бы 5 символов")
    @NotEmpty(message = "Пожалуйста, введите пароль")
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Record> record;
}
