package com.alura.forumhub.dtos;

import com.alura.forumhub.entities.TopicEntity;
import jakarta.validation.constraints.NotBlank;

public record TopicDto(
        String messageResponse,
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String course) {

    public TopicDto(String response, TopicEntity entity) {
        this(
                response,
                entity.getTitle(),
                entity.getMessage(),
                entity.getCourse().getName()
        );
    }
}
