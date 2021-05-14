package br.com.zupacademy.robson.ecommerce.question;

import javax.validation.Valid;
import javax.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zupacademy.robson.ecommerce.user.User;
import br.com.zupacademy.robson.ecommerce.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.zupacademy.robson.ecommerce.product.ProductRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product/{id}")
    @Transactional
    public ResponseEntity<QuestionResponse> save(@RequestBody
            @Valid QuestionRequest questionRequest,
            @AuthenticationPrincipal User user, @PathVariable Long id) {

        Product product = productRepository.findById(id).get();
        Question question = questionRequest.convertToQuestion(user, product);
        questionRepository.save(question);
        System.out.println("sending email " + question.getProduct()
                .getUser().getLogin());
        return ResponseEntity.ok(new QuestionResponse(question));
    }
}
