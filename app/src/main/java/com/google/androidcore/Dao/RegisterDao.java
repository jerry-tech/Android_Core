package com.google.androidcore.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.google.androidcore.models.Register;

import java.util.List;

@Dao
public interface RegisterDao {

    @Query(value = "select * from register order by emailAddress asc")
    LiveData<List<Register>> getAllRegister();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRegistration(Register register);
}
