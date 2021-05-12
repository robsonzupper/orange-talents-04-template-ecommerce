package br.com.zupacademy.robson.ecommerce.question;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    public List<Question> findByProdutoId(Long id);
}
