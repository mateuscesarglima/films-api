package com.films.api.films_api.config;

import java.time.Instant;
import java.util.Arrays;

import com.films.api.films_api.entities.User;
import com.films.api.films_api.repositories.FilmRepository;
import com.films.api.films_api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"test", "dev"})
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private FilmRepository FilmRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "123456789", Instant.parse("15/06/2000"), "");
        User u2 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "123456789", Instant.parse("15/06/2000"), "");
        User u3 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "123456789", Instant.parse("15/06/2000"), "");
        User u4 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "123456789", Instant.parse("15/06/2000"), "");
        
        UserRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
    }


}
