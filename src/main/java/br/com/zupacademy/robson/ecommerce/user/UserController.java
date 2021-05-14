package br.com.zupacademy.robson.ecommerce.user;

import javax.validation.Valid;
import javax.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(OK)
    public ResponseEntity<UserResponse> save(@RequestBody
            @Valid UserRequest userRequest) {

        User user = userRequest.convertToUser();
        userRepository.save(user);
        return ResponseEntity.ok(new UserResponse(user));
    }
}
