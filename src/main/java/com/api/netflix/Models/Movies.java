package com.api.netflix.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="Movies")

public class Movies {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieId;

    @Column(name="moiveName")
    private String movieName;

    @Column(name="movieGenre")
    private String movieGenre;

    @ManyToOne()
    private Categories category;

    private Movies() { }

    public Movies(String movieName, String movieGenre, Categories category) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.category = category;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }
    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Categories getCategory() { return category; }
    public void setCategory(Categories category) { this.category = category; }
}
