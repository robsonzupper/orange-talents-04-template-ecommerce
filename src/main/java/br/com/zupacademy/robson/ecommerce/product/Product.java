package br.com.zupacademy.robson.ecommerce.product;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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

}
