package com.example.cruiseapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.cruiseapp.db.entities.StateRoom;

import java.util.List;

@Dao
public interface StateRoomDao {
    @Insert
    long insertStateRoom(StateRoom stateRoom);

    @Insert
    long[] insertAllStateRoom(List<StateRoom> stateRoom);

    @Query("select * from state_room_table")
    List<StateRoom> getStateRooms();
}
