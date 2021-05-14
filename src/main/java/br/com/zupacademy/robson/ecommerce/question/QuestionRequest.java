package br.com.zupacademy.robson.ecommerce.question;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import br.com.zupacademy.robson.ecommerce.user.User;
import br.com.zupacademy.robson.ecommerce.product.Product;

public class QuestionRequest {

    @NotBlank
    @Length(min = 5)
    private String title;

    @NotBlank
    @Length(max = 500)
    private String content;

    public QuestionRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Question convertToQuestion(User user, Product product) {
        return new Question(this.title, this.content, user, product);
    }
}
