package com.films.api.films_api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.films.api.films_api.model.User;
import com.films.api.films_api.services.UserServices;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestParam String email, @RequestParam String password){

        ResponseEntity<Boolean> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        boolean result = false;
        User user = services.authenticate(email, password);
        if(user != null){
            response = ResponseEntity.ok().body(true);
        }

        return response;

    }


}
