package br.com.zupacademy.robson.ecommerce.product;

import java.util.List;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import br.com.zupacademy.robson.ecommerce.category.Category;
import br.com.zupacademy.robson.ecommerce.validation.ExistsId;
import br.com.zupacademy.robson.ecommerce.feature.FeatureRequest;
import br.com.zupacademy.robson.ecommerce.category.CategoryRepository;

public class ProductRequest {

    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    private BigDecimal value;

    @NotNull
    @Min(0)
    private Integer quantity;

    @Size(min = 3)
    @Valid
    private List<FeatureRequest> features;

    @Length(max = 1000)
    private String description;

    @NotNull
    @ExistsId(domainClass = Category.class, fieldName = "id")
    private Long idCategory;

    public ProductRequest(String name, BigDecimal value, Integer quantity,
            List<FeatureRequest> features, String description, Long idCategory) {

        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.features = features;
        this.description = description;
        this.idCategory = idCategory;
    }

    public Product converteToProduct(CategoryRepository categoryRepository) {
        Category category = categoryRepository.findById(this.idCategory).get();
        return new Product(this.name, this.value, this.quantity,
                this.description, category, this.features);
    }

    public List<FeatureRequest> getFeatures() {
        return features;
    }
}
