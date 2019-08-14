package com.api.netflix.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="movieName")
    private String movieName;

    @Column(name = "movieType")
    private String movieType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(mappedBy ="movies")
    private List<Categories> categories;

//    CONSTRUCTORS
    public Movies() { }

    public Movies(String movieName, String movieType, Users users, List<Categories> categories) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.users = users;
        this.categories = categories;
    }

    //    GETTERS AND SETTERS
    public long getId(Long id) { return this.id; }
    public void setId(long id) { this.id = id; }

    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public List<Categories> getCategories() { return categories; }
    public void setCategories(List<Categories> categories) { this.categories = categories; }

}
