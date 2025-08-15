package com.alura.forumhub.services;

import com.alura.forumhub.entities.UserEntity;
import com.alura.forumhub.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public String tokenGenerator(UserEntity user) {
        String token;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create().withIssuer("API Voll.med")
                            .withSubject(user.getName())
                            .withClaim("email", user.getEmail())
                    .withExpiresAt(expiryDate())
                            .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException(exception);
        }
        return token;
    }

    public String getSubject(String jwtToken) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.require(algorithm)
                    .withIssuer("API Voll.med")
                    .build()
                    .verify(jwtToken)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException(exception);
        }
    }

    private Instant expiryDate() {
        return Instant.now().plus(2, ChronoUnit.HOURS);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username);
    }
}
