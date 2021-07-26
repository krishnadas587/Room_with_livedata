package com.example.room_with_livedata.Repositry;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.room_with_livedata.Database.Database_Home;
import com.example.room_with_livedata.Database.Database_interface;
import com.example.room_with_livedata.Database.Database_models;

import java.util.List;

public class user_repo {
    Database_interface db_interface;
    LiveData<List<Database_models>> db_models;

    Application application;

    public user_repo(Application application) {
        this.application = application;
        Database_Home db_main = Database_Home.getDatabase(application);
        db_interface = db_main.db_inter();
        db_models = db_interface.getAllData();
    }

    public LiveData<List<Database_models>> getDb_models() {
        return db_models;
    }

    public void update(Database_models db_model) {
        doitback(db_model, db_interface,1);
    }
    public void insert(Database_models db_model) {
        doitback(db_model, db_interface,0);
    }

    void doitback(Database_models data_mod, Database_interface interfaced, int operation) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (operation==0){
                 interfaced.insert(data_mod);
                }else if (operation==1){
                    System.out.println(data_mod.getDesignation());
                    interfaced.update(data_mod);
                }


            }
        }).start();
    }

//public class workmanager extends Worker{
//
//    public workmanager(@NonNull Context context, @NonNull WorkerParameters workerParams) {
//        super(context, workerParams);
//    }
//
//    @NonNull
//    @Override
//    public Result doWork() {
//
////        user_repo.db_interface.insert(user_repo.database_models);
//        return Result.success();
//    }
//}

//    private static class insetAsyncTask extends AsyncTask<Database_models, Void, Void> {
//        private Database_interface async_db_inter;
//
//        public insetAsyncTask(Database_interface db_interface) {
//            async_db_inter = db_interface;
//        }
//
//        @Override
//        protected Void doInBackground(Database_models... database_models) {
//            System.out.println("sdjfjskfksbfkbskfnksnkf "+database_models[0]);
//            async_db_inter.insert(database_models[0]);
//            return null;
//        }
//    }
}
