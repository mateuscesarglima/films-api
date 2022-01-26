package com.films.api.films_api.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import com.films.api.films_api.repositories.enumerated.FilmCategory;

@Entity
public class Film implements Serializable {
    
    private Long id;

    private String filmName;

    private String description;

    private FilmCategory filmCategory;

    private String imgUrl;

    public Film() {
    }

    public Film(Long id, String filmName, String description, FilmCategory filmCategory, String imgUrl) {
        this.id = id;
        this.filmName = filmName;
        this.description = description;
        this.filmCategory = filmCategory;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(FilmCategory filmCategory) {
        this.filmCategory = filmCategory;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Film other = (Film) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
