package com.alura.forumhub.repositories;

import com.alura.forumhub.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
    boolean existsByTitle(String title);
    boolean existsByMessage(String message);
}
