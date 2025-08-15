package com.alura.forumhub.controllers;

import com.alura.forumhub.dtos.JwtDto;
import com.alura.forumhub.dtos.LoginDto;
import com.alura.forumhub.entities.UserEntity;
import com.alura.forumhub.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<JwtDto> login(@RequestBody @Valid LoginDto loginDto) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
            var auth = manager.authenticate(authToken);
            var jwtToken = userService.tokenGenerator((UserEntity) auth.getPrincipal());
            return ResponseEntity.ok().body(new JwtDto(jwtToken));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new JwtDto("Usuário ou senha invalido"));
        }
    }
}
