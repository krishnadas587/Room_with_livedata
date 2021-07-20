package com.example.room_with_livedata.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Database_models.class}, version = 1)
public abstract class Database_Home extends RoomDatabase {
    public abstract Database_interface db_inter();

    private static Database_Home INSTANCE;

    public static Database_Home getDatabase(Context ctx) {
        synchronized (Database_Home.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(), Database_Home.class, "USER_DB").fallbackToDestructiveMigration().addCallback(sRoomDatabaseCallback).build();
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

}
