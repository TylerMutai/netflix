package com.api.netflix.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="Movies")

public class Movies {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieId;

    @Column(name="movieName")
    private String movieName;

    @Column(name="movieGenre")
    private String movieGenre;

    @Column(name = "movieType")
    private String movieType;

   // @JoinColumn( ="type")
    //private Categories movieType;



    private Movies() {
    }

    public Movies(String movieName, String movieGenre, String movieType) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieType=movieType;

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

    public String getMovieType() {
        return movieType;
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

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    // public List<Categories> getCategories() {
        //return categories;
   // }

    //public void setCategories(List<Categories> categories) {
        //this.categories = categories;
   // }
}
