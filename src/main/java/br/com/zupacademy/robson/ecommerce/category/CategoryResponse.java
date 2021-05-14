package br.com.zupacademy.robson.ecommerce.category;

public class CategoryResponse {

    private Long id;
    private String name;
    private CategoryResponse categoryMother;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.categoryMother = null;

        if (category.getCategoryMother() != null) {
            this.categoryMother = new CategoryResponse(
                    category.getCategoryMother());
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryResponse getCategoryMother() {
        return categoryMother;
    }
}
