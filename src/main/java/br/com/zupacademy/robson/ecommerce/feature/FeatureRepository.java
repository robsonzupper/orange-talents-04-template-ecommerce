package br.com.zupacademy.robson.ecommerce.feature;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
