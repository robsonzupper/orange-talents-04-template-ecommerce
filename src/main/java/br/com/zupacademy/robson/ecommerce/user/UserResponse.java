package br.com.zupacademy.robson.ecommerce.user;

import java.time.LocalDateTime;

public class UserResponse {

    private Long id;
    private String login;
    private LocalDateTime instanteCriacao;

    public UserResponse(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.instanteCriacao = user.getInstantOfCreation();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }
}
