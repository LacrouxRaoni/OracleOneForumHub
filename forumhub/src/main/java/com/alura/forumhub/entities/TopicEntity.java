package com.alura.forumhub.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @NotBlank
    private String title;

    @NotBlank
    @Lob
    @Column(columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    private TopicStatusEntity status = TopicStatusEntity.NOT_ANSWERED;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserEntity creator;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<AnswerEntity> answers = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    // Getters, Setters, Constructors
    public TopicEntity() {
    }

    public TopicEntity(String title, String message, TopicStatusEntity status, UserEntity creator, CourseEntity course) {
        this.title = title;
        this.message = message;
        this.status = status;
        this.creator = creator;
        this.course = course;
    }

    public Long getId() {return id;}

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status.name();
    }

    public UserEntity getCreator() {
        return creator;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(TopicStatusEntity status) {
        this.status = status;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    // métodos
    public String toString() {
        return "título: " + title + "\nmessage: " + message + "\nstatus: " + status;
    }
}




