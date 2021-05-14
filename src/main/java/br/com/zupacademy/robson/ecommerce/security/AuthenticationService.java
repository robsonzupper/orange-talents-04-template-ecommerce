package br.com.zupacademy.robson.ecommerce.security;

import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.zupacademy.robson.ecommerce.user.User;
import br.com.zupacademy.robson.ecommerce.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByLogin(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("invalid data!");
    }
}
