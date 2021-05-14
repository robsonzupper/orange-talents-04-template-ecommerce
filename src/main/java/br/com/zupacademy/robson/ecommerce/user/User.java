package br.com.zupacademy.robson.ecommerce.user;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import br.com.zupacademy.robson.ecommerce.profile.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "user")
public class User implements Serializable, UserDetails {

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
        this.encryptPassword(password);
    }

    public void encryptPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.profiles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
