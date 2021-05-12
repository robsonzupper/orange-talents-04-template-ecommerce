package br.com.zupacademy.robson.ecommerce.user;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByLogin(String login);
}
