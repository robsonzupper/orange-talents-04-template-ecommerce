package br.com.zupacademy.robson.ecommerce.category;

import javax.validation.constraints.NotBlank;
import br.com.zupacademy.robson.ecommerce.validation.ExistsId;
import br.com.zupacademy.robson.ecommerce.validation.UniqueValue;

public class CategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    @ExistsId(domainClass = Category.class, fieldName = "id")
    private Long idCategoryMother;

    public CategoryRequest(String name, Long idCategoryMother) {
        this.name = name;
        this.idCategoryMother = idCategoryMother;
    }

    public Category convertToCategory(
            CategoryRepository categoryRepository) {

        Category category = new Category(this.name);
        if (this.idCategoryMother != null) {
            Category categoryMother = categoryRepository
                    .findById(this.idCategoryMother).get();
            category.setCategoryMother(categoryMother);
        }
        return category;
    }
}
