package br.com.zupacademy.robson.ecommerce.opinion;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import br.com.zupacademy.robson.ecommerce.user.User;
import br.com.zupacademy.robson.ecommerce.product.Product;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "opinion")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer note;
    private String title;
    private String description;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    public Opinion() {
    }

    public Opinion(Integer note, String title, String description,
            Product product, User user) {

        this.note = note;
        this.title = title;
        this.description = description;
        this.product = product;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

}
