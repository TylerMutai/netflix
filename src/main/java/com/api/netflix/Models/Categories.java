package com.api.netflix.Models;

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





    private Categories() {
    }

    public Categories(Integer categoryId, String type) {
        this.categoryId = categoryId;
        this.type = type;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
