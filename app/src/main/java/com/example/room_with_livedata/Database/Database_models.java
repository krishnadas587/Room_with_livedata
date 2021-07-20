package com.example.room_with_livedata.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_datas")
public class Database_models {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;
    @ColumnInfo(name = "NAME")
    private String name;
    @ColumnInfo(name = "DESIGNATION")
    private String designation;
    @ColumnInfo(name = "DATE")
    private String date;

    public Database_models(String name, String designation, String date) {
        this.name = name;
        this.designation = designation;
        this.date = date;
    }

    public Database_models() {
        this.id = 0;
        this.name = "";
        this.designation = "";
        this.date = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
