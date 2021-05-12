package br.com.zupacademy.robson.ecommerce.feature;

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
@Table(name = "feature")
public class Feature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String descsription;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescsription() {
        return descsription;
    }

}
