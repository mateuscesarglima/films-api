package com.films.api.films_api.services;

import java.util.List;
import java.util.Optional;

import com.films.api.films_api.entities.User;
import com.films.api.films_api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository repository;

    public List<User> findall(){
       return repository.findAll();
    }

    public User findById(Long id){

       Optional<User> obj = repository.findById(id);

       return obj.get();

    }

}
