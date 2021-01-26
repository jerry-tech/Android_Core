package com.google.androidcore.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.google.androidcore.Dao.RegisterDao;
import com.google.androidcore.models.Register;

@Database(entities = {Register.class}, version = 1, exportSchema = false)
public abstract class RegisterDatabase extends RoomDatabase {

    public abstract RegisterDao registerDao();
    private static RegisterDatabase INSTANCE;

    public static RegisterDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RegisterDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RegisterDatabase.class, "register")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
//                            .addCallback(sRoomDatabaseCallback)//
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                }
            };
}

