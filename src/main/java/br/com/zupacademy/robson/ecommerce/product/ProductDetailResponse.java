package br.com.zupacademy.robson.ecommerce.product;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import br.com.zupacademy.robson.ecommerce.opinion.Opinion;
import br.com.zupacademy.robson.ecommerce.question.Question;
import br.com.zupacademy.robson.ecommerce.feature.FeatureResponse;
import br.com.zupacademy.robson.ecommerce.opinion.OpinionResponse;
import br.com.zupacademy.robson.ecommerce.question.QuestionResponse;

public class ProductDetailResponse {

    private List<String> linksImages = new ArrayList<>();
    private String product;
    private BigDecimal price;
    private List<FeatureResponse> features;
    private String description;
    private Double averageByGrades = 0.0;
    private Integer totalGrade = 0;
    private List<OpinionResponse> productReviews = new ArrayList<>();
    private List<QuestionResponse> productIssues = new ArrayList<>();

    public ProductDetailResponse(Product product, List<Opinion> opinions,
            List<Question> questions) {

        this.product = product.getName();
        this.price = product.getValue();
        this.features = FeatureResponse.convertToFeatureResponse(
                product.getFeatures());

        this.description = product.getDescription();
        this.averageByGrades = average(opinions);
        this.totalGrade = totalGrade(opinions);

        opinions.forEach(opinion -> productReviews.
                add(new OpinionResponse(opinion)));

        questions.forEach(question -> productIssues.
                add(new QuestionResponse(question)));

        product.getImages().forEach(image -> linksImages.
                add(image.getLink()));

    }

    private Integer totalGrade(List<Opinion> opinions) {
        Integer notaTotal = 0;
        for (Opinion opinion : opinions) {
            notaTotal += opinion.getNote();
        }
        return notaTotal;
    }

    public Double average(List<Opinion> opinioes) {
        Double media = 0.0;
        for (Opinion opinion : opinioes) {
            media += opinion.getNote();
        }
        return media /= opinioes.size();
    }

    public List<String> getLinksImages() {
        return linksImages;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<FeatureResponse> getFeatures() {
        return features;
    }

    public String getDescription() {
        return description;
    }

    public Double getAverageByGrades() {
        return averageByGrades;
    }

    public Integer getTotalGrade() {
        return totalGrade;
    }

    public List<OpinionResponse> getProductReviews() {
        return productReviews;
    }

    public List<QuestionResponse> getProductIssues() {
        return productIssues;
    }

}
