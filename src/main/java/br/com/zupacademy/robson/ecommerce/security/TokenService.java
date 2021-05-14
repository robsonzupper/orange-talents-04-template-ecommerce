package br.com.zupacademy.robson.ecommerce.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import br.com.zupacademy.robson.ecommerce.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {

        User logged = (User) authentication.getPrincipal();
        Date today = new Date();
        Date expiracao = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Orange Talents")
                .setSubject(logged.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret)
                .parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

}
