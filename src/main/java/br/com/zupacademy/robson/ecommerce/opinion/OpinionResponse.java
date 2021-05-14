package br.com.zupacademy.robson.ecommerce.opinion;

import br.com.zupacademy.robson.ecommerce.user.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.zupacademy.robson.ecommerce.product.ProductResponse;

@JsonIgnoreProperties({"product"})
public class OpinionResponse {

    private Long id;
    private Integer note;
    private String title;
    private String description;
    private UserResponse user;
    private ProductResponse product;

    public OpinionResponse(Opinion opinion) {
        this.id = opinion.getId();
        this.note = opinion.getNote();
        this.title = opinion.getTitle();
        this.description = opinion.getDescription();
        this.user = new UserResponse(opinion.getUser());
        this.product = new ProductResponse(opinion.getProduct());
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

    public UserResponse getUser() {
        return user;
    }

    public ProductResponse getProduct() {
        return product;
    }
}
