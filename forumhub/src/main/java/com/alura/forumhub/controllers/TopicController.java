package com.alura.forumhub.controllers;

import com.alura.forumhub.dtos.*;
import com.alura.forumhub.entities.TopicEntity;
import com.alura.forumhub.exceptions.ForumHubExceptions;
import com.alura.forumhub.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @GetMapping
    public ResponseEntity<List<TopicGetDto>> getTopic() {
        try {
            List<TopicGetDto> topics = topicService.findAll()
                    .stream()
                    .map(TopicGetDto::new)
                    .toList();
            return ResponseEntity.ok(topics);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTopicById(@PathVariable Long id) {
        try {
        TopicEntity topic = topicService.findTopicById(id);
        return ResponseEntity.ok(new TopicGetDto(topic));
        } catch (ForumHubExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> createTopic(@Valid @RequestBody TopicDto topicDTO) {
        try {
            TopicEntity createdTopic = topicService.createTopic(topicDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new TopicDto("Tópico criado com sucesso!",createdTopic));
        } catch (RuntimeException | ForumHubExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putTopic(@PathVariable Long id, @Valid @RequestBody TopicDto topicDTO) {
        try {
            TopicEntity topic = topicService.updateTopic(id, topicDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new TopicDto("Tópico modificado com sucesso!", topic));
        } catch (ForumHubExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        try {
            TopicEntity topic = topicService.removeTopic(id);
            return ResponseEntity.status(HttpStatus.OK).body(new TopicDto("Tópico removido com sucesso!", topic));
        } catch (ForumHubExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
        }
    }
}
