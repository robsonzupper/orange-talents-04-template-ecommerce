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
    private String descsription;

    @ManyToOne
    private Product product;

    public Feature() {
    }

    public Feature(Long id, String name, String descsription, Product product) {
        this.id = id;
        this.name = name;
        this.descsription = descsription;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescsription() {
        return descsription;
    }

    public Product getProduct() {
        return product;
    }

}
