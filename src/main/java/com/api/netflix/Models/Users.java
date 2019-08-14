package com.api.netflix.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="firstName")
    private String firstName;

    @Column(name ="lastName")
    private String lastName;

    @Column(name ="nationalID")
    private Integer nationalID;

    @OneToMany(mappedBy ="users")
    private List<Movies> movies;

//    CONSTRUCTORS
    public Users() { }

    public Users(String firstName, String lastName, Integer nationalID, List <Movies> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalID = nationalID;
        this.movies=movies;
    }

//    GETTERS AND SETTERS
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNationalID() {
        return nationalID;
    }
    public void setNationalID(Integer nationalID) {
        this.nationalID = nationalID;
    }

    public List<Movies> getMovies() { return movies; }
    public void setMovies(List<Movies> movies) { this.movies = movies; }
}
