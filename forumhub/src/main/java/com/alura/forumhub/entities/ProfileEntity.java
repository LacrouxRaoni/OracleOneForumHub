package com.alura.forumhub.entities;

import jakarta.persistence.*;

@Table(name = "profile")
@Entity
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    // Getters e Setters
}
