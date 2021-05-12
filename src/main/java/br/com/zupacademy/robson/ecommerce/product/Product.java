package br.com.zupacademy.robson.ecommerce.product;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import br.com.zupacademy.robson.ecommerce.image.Image;
import br.com.zupacademy.robson.ecommerce.feature.Feature;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private BigDecimal value;
    private Integer quantity;
    private String description;
    private LocalDateTime instantOfCreation = LocalDateTime.now();

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<Feature> features = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private Set<Image> images = new HashSet<>();

    public void addImage(Set<String> links) {

        links.forEach(link -> images.add(new Image(link, this)));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getInstantOfCreation() {
        return instantOfCreation;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public Set<Image> getImages() {
        return images;
    }

}
