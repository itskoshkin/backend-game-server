package edu.ssstoyanov.webserver.Model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Stanislav Stoianov
 * creation date: 17/04/20.
 * @since 1.0
 */

// TODO: 20.04.2020  

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", unique = true, nullable = false)
    private int id;

    @Column(name = "login", unique = true, nullable = false, length = 32)
    private String login;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Record> records;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
