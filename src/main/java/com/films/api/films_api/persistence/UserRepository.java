package com.films.api.films_api.persistence;

import com.films.api.films_api.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
