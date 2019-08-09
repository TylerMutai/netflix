package com.api.netflix.Models;

import javax.persistence.*;


@Entity
@Table(name="Categories")

public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long entryID;

    @Column(name ="type")
    private String type;


    private Categories() {
    }

    public Categories(String type) {
        this.type = type;
    }

    public long getEntryID() {
        return entryID;
    }

    public void setEntryID(long entryID) {
        this.entryID = entryID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
