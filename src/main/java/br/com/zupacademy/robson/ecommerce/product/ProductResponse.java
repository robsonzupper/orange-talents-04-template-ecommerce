package br.com.zupacademy.robson.ecommerce.product;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import br.com.zupacademy.robson.ecommerce.user.UserResponse;
import br.com.zupacademy.robson.ecommerce.feature.FeatureResponse;
import br.com.zupacademy.robson.ecommerce.category.CategoryResponse;

public class ProductResponse {

    private Long id;
    private String name;
    private BigDecimal value;
    private Integer quantity;
    private List<FeatureResponse> features;
    private String description;
    private CategoryResponse category;
    private LocalDateTime instantOfCreation;
    private UserResponse user;
    private List<String> linkImages = new ArrayList<>();

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.value = product.getValue();
        this.quantity = product.getQuantity();
        this.features = FeatureResponse.convertToFeatureResponse(
                product.getFeatures());
        this.description = product.getDescription();
        this.instantOfCreation = product.getInstantOfCreation();
        this.user = new UserResponse(product.getUser());
        this.category = new CategoryResponse(product.getCategory());
        product.getImages().forEach(imagem -> {
            this.linkImages.add(imagem.getLink());
        });
    }

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

    public List<FeatureResponse> getFeatures() {
        return features;
    }

    public String getDescription() {
        return description;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public LocalDateTime getInstantOfCreation() {
        return instantOfCreation;
    }

    public UserResponse getUser() {
        return user;
    }

    public List<String> getLinksImagens() {
        return linkImages;
    }
}
