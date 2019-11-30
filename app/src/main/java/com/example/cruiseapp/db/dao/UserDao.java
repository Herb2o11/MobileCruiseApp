package com.example.cruiseapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cruiseapp.db.entities.User;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface UserDao {

    @Query("select * from users_table")
    List<User> getUsers();

    @Query("select * from users_table where id = :id limit 1")
    User getUser(long id);

    @Query("select * from users_table where email = :email limit 1")
    User getUser(String email);

    @Insert(onConflict = IGNORE)
    long insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
