package br.com.zupacademy.robson.ecommerce.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import br.com.zupacademy.robson.ecommerce.validation.UniqueValue;

public class UserRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = User.class, fieldName = "login")
    private String login;

    @NotBlank
    @Length(min = 6)
    private String senha;

    public UserRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public User convertToUser() {
        return new User(login, senha);
    }
}
