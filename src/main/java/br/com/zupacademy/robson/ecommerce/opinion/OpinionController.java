package br.com.zupacademy.robson.ecommerce.opinion;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zupacademy.robson.ecommerce.user.User;
import static org.springframework.http.HttpStatus.OK;
import br.com.zupacademy.robson.ecommerce.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.zupacademy.robson.ecommerce.product.ProductRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/opinion")
public class OpinionController {

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<OpinionResponse> cadastra(@RequestBody
            @Valid OpinionRequest opinionRequest, @PathVariable Long id,
            @AuthenticationPrincipal User user) {

        Product product = productRepository.findById(id).get();
        Opinion opinion = opinionRequest.converteToOpinion(user, product);
        opinionRepository.save(opinion);
        return ResponseEntity.ok(new OpinionResponse(opinion));
    }
}
