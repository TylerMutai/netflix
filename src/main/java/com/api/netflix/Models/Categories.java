package com.api.netflix.Models;

import javax.persistence.*;


@Entity
@Table(name="Categories")

public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long entryID;

    @JoinColumn(name ="nationalID")
    private Users users;

    @Column(name ="type")
    private String type;






}
