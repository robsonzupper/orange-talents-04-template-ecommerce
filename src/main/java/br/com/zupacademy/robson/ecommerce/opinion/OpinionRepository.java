package br.com.zupacademy.robson.ecommerce.opinion;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {

    public List<Opinion> findByProdutoId(Long id);
}
