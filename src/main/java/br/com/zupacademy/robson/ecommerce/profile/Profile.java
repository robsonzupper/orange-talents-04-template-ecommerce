package br.com.zupacademy.robson.ecommerce.profile;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    public Profile() {
    }

    public Profile(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
