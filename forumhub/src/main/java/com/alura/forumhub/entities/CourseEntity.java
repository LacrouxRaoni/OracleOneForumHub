package com.alura.forumhub.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<TopicEntity> topics = new ArrayList<>();

    // Getters e Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
