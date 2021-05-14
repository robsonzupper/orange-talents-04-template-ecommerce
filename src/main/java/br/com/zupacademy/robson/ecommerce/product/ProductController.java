package br.com.zupacademy.robson.ecommerce.product;

import java.util.Set;
import java.util.List;
import javax.validation.Valid;
import javax.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zupacademy.robson.ecommerce.user.User;
import br.com.zupacademy.robson.ecommerce.opinion.Opinion;
import br.com.zupacademy.robson.ecommerce.question.Question;
import br.com.zupacademy.robson.ecommerce.image.ImageRequest;
import br.com.zupacademy.robson.ecommerce.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.zupacademy.robson.ecommerce.feature.FeatureRepository;
import br.com.zupacademy.robson.ecommerce.opinion.OpinionRepository;
import br.com.zupacademy.robson.ecommerce.question.QuestionRepository;
import br.com.zupacademy.robson.ecommerce.category.CategoryRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FeatureRepository featureRepository;

    @Autowired
    private UploaderFake uploaderFake;
    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ProductResponse> save(@RequestBody
            @Valid ProductRequest productRequest,
            @AuthenticationPrincipal User user) {

        Product product = productRequest.converteToProduct(categoryRepository);
        product.setUser(user);

        productRepository.save(product);

        return ResponseEntity.ok(new ProductResponse(product));

    }

    @PatchMapping("/{id}/addImage")
    @Transactional
    public ResponseEntity<ProductResponse> adicionaImage(
            @Valid ImageRequest imageRequest, @PathVariable Long id,
            @AuthenticationPrincipal User user) {

        Product product = productRepository.findById(id).get();

        if (!product.getUser().equals(user)) {
            return ResponseEntity.badRequest().build();
        }

        Set<String> links = uploaderFake.envia(imageRequest.getImages());
        product.addImage(links);
        return ResponseEntity.ok(new ProductResponse(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> detalhe(@PathVariable Long id) {
        Product product = productRepository.findById(id).get();
        List<Opinion> opinioes = opinionRepository.findByProductId(id);
        List<Question> questions = questionRepository.findByProductId(id);
        ProductDetailResponse productDetalheResponse
                = new ProductDetailResponse(product, opinioes, questions);
        return ResponseEntity.ok(productDetalheResponse);
    }
}
