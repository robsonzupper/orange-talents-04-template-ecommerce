package br.com.zupacademy.robson.ecommerce.image;

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
@Table(name = "image")
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String link;

    public Image() {
    }

    public Image(String link, Product product) {
        this.link = link;
        this.product = product;
    }

    @ManyToOne
    private Product product;

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public Product getProduct() {
        return product;
    }

}
