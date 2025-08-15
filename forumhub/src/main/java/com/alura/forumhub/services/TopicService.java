package com.alura.forumhub.services;

import com.alura.forumhub.dtos.TopicDto;
import com.alura.forumhub.entities.CourseEntity;
import com.alura.forumhub.entities.TopicEntity;
import com.alura.forumhub.entities.TopicStatusEntity;
import com.alura.forumhub.entities.UserEntity;
import com.alura.forumhub.exceptions.ForumHubExceptions;
import com.alura.forumhub.repositories.CourseRepository;
import com.alura.forumhub.repositories.TopicRepository;
import com.alura.forumhub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public TopicEntity createTopic(TopicDto topicDTO) throws ForumHubExceptions {
        if (topicRepository.existsByTitle(topicDTO.title())) {
            throw new ForumHubExceptions("Já existe um tópico com este título");
        }
        if (topicRepository.existsByMessage(topicDTO.message())) {
            throw new ForumHubExceptions("Já existe um tópico com esta mensagem");
        }

        CourseEntity course = findCouse(topicDTO);
        UserEntity user = getCurrentUser();
        TopicEntity topic = setTopicEntity(false, null, topicDTO, user, course);
        return topicRepository.save(topic);
    }

    public List<TopicEntity> findAll() {
        return topicRepository.findAll();
    }

    public TopicEntity findTopicById(Long id) throws ForumHubExceptions {
        TopicEntity topic = topicRepository.findById(id).orElse(null);
        if (topic == null) {
            throw new ForumHubExceptions("Topico não encontrado.");
        }
        return topic;
    }

    public TopicEntity updateTopic(Long id, TopicDto topicDTO) throws ForumHubExceptions {
        CourseEntity course = findCouse(topicDTO);
        UserEntity user = getCurrentUser();
        TopicEntity topic = setTopicEntity(true, id, topicDTO, user, course);
        topicRepository.save(topic);

        return topic;
    }

    public TopicEntity removeTopic(Long id) throws ForumHubExceptions {
        TopicEntity topic = findTopicById(id);
        topicRepository.delete(topic);
        return topic;
    }

    private UserEntity getCurrentUser() {
        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        return userRepository.getByName(username);
    }

    private TopicEntity setTopicEntity(boolean isPut, Long id, TopicDto topicDTO, UserEntity user, CourseEntity course) throws ForumHubExceptions {
        TopicEntity topic = null;
        if (isPut) {
            topic = findTopicById(id);
            topic.setTitle(topicDTO.title());
            topic.setMessage(topicDTO.message());
            topic.setCourse(course);
            topic.setCreator(user);
        } else {
            topic = new TopicEntity(topicDTO.title(),topicDTO.message(),TopicStatusEntity.NOT_ANSWERED,user,course);
        }
        return topic;
    }

    private CourseEntity findCouse(TopicDto topic) {
        return courseRepository.findByName(topic.course())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado: " + topic.course()));
    }


}
