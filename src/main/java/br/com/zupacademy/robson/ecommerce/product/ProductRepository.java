package br.com.zupacademy.robson.ecommerce.product;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
