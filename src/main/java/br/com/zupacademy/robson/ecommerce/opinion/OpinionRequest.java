package br.com.zupacademy.robson.ecommerce.opinion;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import br.com.zupacademy.robson.ecommerce.user.User;
import br.com.zupacademy.robson.ecommerce.product.Product;

public class OpinionRequest {

    @Min(1)
    @Max(5)
    private Integer note;

    @NotBlank
    private String title;

    @NotBlank
    @Length(max = 500)
    private String description;

    public OpinionRequest(Integer note, String title, String description) {
        this.note = note;
        this.title = title;
        this.description = description;
    }

    public Opinion converteToOpinion(User user, Product product) {
        return new Opinion(this.note, this.title, this.description, product, user);
    }
}
