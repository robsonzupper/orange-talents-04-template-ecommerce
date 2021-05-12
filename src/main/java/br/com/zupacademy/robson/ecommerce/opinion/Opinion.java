package br.com.zupacademy.robson.ecommerce.opinion;

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
@Table(name = "opinion")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer note;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public Integer getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
