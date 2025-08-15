package com.alura.forumhub.dtos;

public record JwtDto (String jwtToken) {

    public JwtDto (String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
