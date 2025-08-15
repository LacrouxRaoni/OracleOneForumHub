package com.alura.forumhub.repositories;


import com.alura.forumhub.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserDetails findByName(String name);

    UserEntity getByName(String username);
}
