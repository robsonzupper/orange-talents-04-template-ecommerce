package br.com.zupacademy.robson.ecommerce.category;

import javax.validation.Valid;
import javax.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(OK)
    public ResponseEntity<CategoryResponse> save(@RequestBody
            @Valid CategoryRequest categoryRequest) {

        Category category = categoryRequest.convertToCategory(categoryRepository);
        categoryRepository.save(category);
        return ResponseEntity.ok(new CategoryResponse(category));
    }
}
