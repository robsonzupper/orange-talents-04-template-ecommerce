package br.com.zupacademy.robson.ecommerce.question;

import java.time.LocalDateTime;
import br.com.zupacademy.robson.ecommerce.user.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.zupacademy.robson.ecommerce.product.ProductResponse;

@JsonIgnoreProperties({"product"})
public class QuestionResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime instantOfCreation = LocalDateTime.now();
    private UserResponse user;
    private ProductResponse product;

    public QuestionResponse(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.instantOfCreation = question.getIntantOfCreation();
        this.user = new UserResponse(question.getUser());
        this.product = new ProductResponse(question.getProduct());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getInstantOfCreation() {
        return instantOfCreation;
    }

    public UserResponse getUser() {
        return user;
    }

    public ProductResponse getProduct() {
        return product;
    }
}
