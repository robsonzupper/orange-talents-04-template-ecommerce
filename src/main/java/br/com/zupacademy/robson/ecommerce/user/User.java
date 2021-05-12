package br.com.zupacademy.robson.ecommerce.user;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String login;
    private String password;

    @NotNull
    @PastOrPresent
    private LocalDateTime instantOfCreation = LocalDateTime.now();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Deprecated
    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return password;
    }

    public LocalDateTime getInstantOfCreation() {
        return instantOfCreation;
    }

}
