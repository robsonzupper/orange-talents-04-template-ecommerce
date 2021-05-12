package br.com.zupacademy.robson.ecommerce.category;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne
    private Category categoriaMother;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public void setCategoryMother(Category categoriaMother) {
        this.categoriaMother = categoriaMother;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategoryMother() {
        return categoriaMother;
    }
}
