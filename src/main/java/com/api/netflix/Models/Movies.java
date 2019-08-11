package com.api.netflix.Models;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

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


    @ManyToOne
    @JoinColumn(name = "UserId",nullable = false)
    private Users users;

    @OneToMany(mappedBy ="movies")
    private Set<Categories> categories;





    public Movies() {
    }

    public Movies(String movieName, String movieGenre, String movieType, Users users, Set<Categories> categories) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieType = movieType;
        this.users = users;
        this.categories = categories;
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

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }
}
