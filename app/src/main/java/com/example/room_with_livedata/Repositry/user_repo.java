package com.example.room_with_livedata.Repositry;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.room_with_livedata.Database.Database_Home;
import com.example.room_with_livedata.Database.Database_interface;
import com.example.room_with_livedata.Database.Database_models;

import java.util.List;

public class user_repo {
    private Database_interface db_interface;
    private LiveData<List<Database_models>> db_models;

    public user_repo(Application application) {
        Database_Home db_main = Database_Home.getDatabase(application);
        db_interface = db_main.db_inter();
        db_models = db_interface.getAllData();
    }

    public LiveData<List<Database_models>> getDb_models() {
        return db_models;
    }

    public void insert(Database_models db_model) {
        new insetAsyncTask(db_interface).execute(db_model);
    }

    private static class insetAsyncTask extends AsyncTask<Database_models, Void, Void> {
        private Database_interface async_db_inter;

        public insetAsyncTask(Database_interface db_interface) {
            async_db_inter = db_interface;
        }

        @Override
        protected Void doInBackground(Database_models... database_models) {
            async_db_inter.insert(database_models[0]);
            return null;
        }
    }
}
