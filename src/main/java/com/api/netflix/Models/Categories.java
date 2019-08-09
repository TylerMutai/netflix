package com.api.netflix.Models;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="categories")

public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long entryID;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name ="type")
    private String type;

    @OneToMany(mappedBy ="category")
    private List<Movies> movies;


    private Categories() { }

    public Categories(String type) {

        this.type = type;
    }

//    Getters And Setters
    public long getEntryID() { return entryID; }
    public void setEntryID(long entryID) {
        this.entryID = entryID;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public List<Movies> getMovies() {
        return movies;
    }
    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}
