package com.films.api.films_api.repositories;

import com.films.api.films_api.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User>{
    
}
