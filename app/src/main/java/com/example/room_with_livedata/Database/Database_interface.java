package com.example.room_with_livedata.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Database_interface {

    @Query("SELECT * FROM User_datas")
    LiveData<List<Database_models>> getAllData();

    @Insert
    void insert(Database_models db_model);

    @Query("DELETE FROM User_datas")
    void deleteAll();



}
