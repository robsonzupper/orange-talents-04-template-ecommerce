package br.com.zupacademy.robson.ecommerce.feature;

import java.util.List;
import java.util.ArrayList;
import br.com.zupacademy.robson.ecommerce.feature.Feature;
import br.com.zupacademy.robson.ecommerce.product.Product;
import org.springframework.stereotype.Component;

/**
 *
 * @author Robson
 */
@Component
public class FeatureRequest {

    private String name;
    private String description;

    public FeatureRequest() {
    }

    public FeatureRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private Feature convert(Product product) {
        return new Feature(this.name, this.description, product);
    }

    public static List<Feature> convertToList(List<FeatureRequest> list, Product product) {
        List<Feature> features = new ArrayList<>();
        for (FeatureRequest aux : list) {
            Feature feature = aux.convert(product);
            features.add(feature);
        }
        return features;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
