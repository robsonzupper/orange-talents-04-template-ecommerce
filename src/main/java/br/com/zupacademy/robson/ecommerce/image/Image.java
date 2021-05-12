package br.com.zupacademy.robson.ecommerce.image;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "image")
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String link;

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

}
