package com.api.netflix.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="movies")

public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieId;

    @Column(name="movieName")
    private String movieName;

    @Column(name = "movieType")
    private String movieType;

//    @Column(name="movieGenre")
//    private String movieGenre;

    @ManyToOne()
    private Categories category;


    private Movies() { }

    public Movies(String movieName, String movieGenre, Categories category,String movieType) {
        this.movieName = movieName;
//        this.movieGenre = movieGenre;
        this.category = category;
        this.movieType = movieType;
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

    public String getMovieType() { return movieType; }
    public void setMovieType(String movieType) { this.movieType = movieType; }

//    public String getMovieGenre() {
//        return movieGenre;
//    }
//    public void setMovieGenre(String movieGenre) {
//        this.movieGenre = movieGenre;
//    }

    public Categories getCategory() { return category; }
    public void setCategory(Categories category) { this.category = category; }
}
