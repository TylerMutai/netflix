package com.api.netflix.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="Users")

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name ="firstName")
    private String firstName;

    @Column(name ="lastName")
    private String lastName;

    @Column(name ="nationalID")
    private Integer nationalID;

   // @OneToMany(mappedBy ="Movies")
   // private List<Movies> movies;

    private Users() {
    }


    public Users(String firstName, String lastName, Integer nationalID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalID = nationalID;
        //this.movies=movies;
    }

    public long getId() {
        return userId;
    }

    public void setId(long id) {
        this.userId = id;
    }

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

   // public List<Movies> getMovies() {
   //     return movies;
   // }

    //public void setMovies(List<Movies> movies) {
       // this.movies = movies;
   // }
}
