package br.com.zupacademy.robson.ecommerce.question;

import java.io.Serializable;
import javax.persistence.Id;
import java.time.LocalDateTime;
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
@Table(name = "question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    public Question(String title, String content, User user, Product product) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.product = product;
    }

    @Deprecated
    public Question() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public String getContent() {
        return content;
    }
}
