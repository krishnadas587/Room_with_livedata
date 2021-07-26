package com.example.room_with_livedata.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.room_with_livedata.Database.Database_models;
import com.example.room_with_livedata.Repositry.user_repo;

import java.util.List;

public class TodoViewModels extends AndroidViewModel {
    private user_repo repository;
    private LiveData<List<Database_models>> db_models;
    public TodoViewModels(@NonNull Application application) {
        super(application);
        System.out.println("called");
        repository=new user_repo(application);
        db_models=repository.getDb_models();
    }
   public LiveData<List<Database_models>> fetch_live(){
        return db_models;
    }
    public void insert(@NonNull Database_models datas){
        repository.insert(datas);
    }
    public void update(@NonNull Database_models datas){

        repository.update(datas);
    }
}
