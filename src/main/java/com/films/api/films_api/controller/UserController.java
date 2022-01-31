package com.films.api.films_api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.films.api.films_api.model.User;
import com.films.api.films_api.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserController {

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody User obj, @PathVariable Long id){
        
        obj = services.update(obj, id);

        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        services.deleteById(id);

        return ResponseEntity.noContent().build();


    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody @Valid User obj){
        
        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }
}