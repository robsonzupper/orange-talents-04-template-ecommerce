package br.com.zupacademy.robson.ecommerce.user;

import br.com.zupacademy.robson.ecommerce.profile.Profile;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.EAGER)
    List<Profile> profiles = new ArrayList<>();

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
