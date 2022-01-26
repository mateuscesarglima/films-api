package com.films.api.films_api.resources;

import java.util.List;

import com.films.api.films_api.entities.User;
import com.films.api.films_api.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices services;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        ResponseEntity<List<User>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<User> obj = services.findAll();

        if(!obj.isEmpty()){
            response = ResponseEntity.ok().body(obj);
        }

        return response;
        
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        
        User obj = services.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
