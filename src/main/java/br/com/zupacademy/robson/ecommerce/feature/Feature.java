package br.com.zupacademy.robson.ecommerce.feature;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import br.com.zupacademy.robson.ecommerce.product.Product;

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
    private String description;

    @ManyToOne
    private Product product;

    public Feature() {
    }

    public Feature(String name, String description, Product product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Product getProduct() {
        return product;
    }

}
