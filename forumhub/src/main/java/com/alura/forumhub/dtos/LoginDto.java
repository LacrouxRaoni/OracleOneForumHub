package com.alura.forumhub.dtos;


import jakarta.validation.constraints.NotBlank;

public record LoginDto(@NotBlank String username, @NotBlank String email, @NotBlank String password) {
}
