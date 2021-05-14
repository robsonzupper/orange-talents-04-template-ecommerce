package br.com.zupacademy.robson.ecommerce.feature;

import java.util.List;
import java.util.ArrayList;

public class FeatureResponse {

    private Long id;
    private String name;
    private String description;

    public FeatureResponse(Feature feature) {
        this.id = feature.getId();
        this.name = feature.getName();
        this.description = feature.getDescription();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<FeatureResponse> convertToFeatureResponse(List<Feature> features) {
        List<FeatureResponse> featuresResponse = new ArrayList<>();
        for (Feature aux : features) {
            FeatureResponse featureResponse = new FeatureResponse(aux);
            featuresResponse.add(featureResponse);
        }
        return featuresResponse;
    }

}
