package com.alura.forumhub.dtos;

import com.alura.forumhub.entities.TopicEntity;

import java.time.LocalDateTime;

public record TopicGetDto(Long id,
                          String title,
                          String message,
                          String course,
                          LocalDateTime creationDate,
                          String creator,
                          String status) {


    public TopicGetDto(TopicEntity entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getCourse().getName(),
                entity.getCreationDate(),
                entity.getCreator().getName(),
                entity.getStatus()
        );
    }


}
