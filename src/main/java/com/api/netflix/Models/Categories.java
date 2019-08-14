package com.api.netflix.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long catId;

    @Column(name ="category")
    private String category;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="movie_id")
    private Movies movies;

//    CONSTRUCTORS
    public Categories() { }

    public Categories(String category, Movies movies) {
        this.category = category;
        this.movies = movies;
    }

//    GETTERS AND SETTERS
    public long getCatId() {
        return catId;
    }
    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Movies getMovies() { return movies; }
    public void setMovies(Movies movies) { this.movies = movies; }
}
