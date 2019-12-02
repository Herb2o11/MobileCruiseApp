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

    @Query("select * from state_room_table where room_location == 'Mid' and room_category == 'Intermediate'")
          List<StateRoom> getmidIntermediateStateRoom();
    //  StateRoom getStateRoom (String roomLocation,String roomCategory);

    @Query("select * from state_room_table where room_location == 'Mid' and room_category == 'Deluxe'")
    List<StateRoom> getmidDeluxeStateRoom();

    @Query("select * from state_room_table where room_location == 'Mid' and room_category == 'Standard'")
    List<StateRoom> getmidStandardStateRoom();

    @Query("select * from state_room_table where room_location == 'Foward' and room_category == 'Intermediate'")
    List<StateRoom> getFowardIntermediateStateRoom();

    @Query("select * from state_room_table where room_location == 'Foward' and room_category == 'Deluxe'")
    List<StateRoom> getFowardDeluxeStateRoom();

    @Query("select * from state_room_table where room_location == 'Foward' and room_category == 'Standard'")
    List<StateRoom> getFowardStandardStateRoom();

    @Query("select * from state_room_table where room_location == 'Aft' and room_category == 'Standard'")
    List<StateRoom> getAftStandardStateRoom();

    @Query("select * from state_room_table where room_location == 'Aft' and room_category == 'Intermediate'")
    List<StateRoom> getAftIntermediatetateRoom();

    @Query("select * from state_room_table where room_location == 'Aft' and room_category == 'Deluxe'")
    List<StateRoom> getAftDeluxeStateRoom();

    @Query("select * from state_room_table where room_location == 'Foward'" )
    List<StateRoom> getFowardStateRoom();

    @Query("select * from state_room_table where room_location == 'Aft'" )
    List<StateRoom> getAftStateRoom();

    @Query("select * from state_room_table where room_location == 'Mid'" )
    List<StateRoom> getMidStateRoom();

    //StateRoom getStateRoom (String roomLocation,String roomCategory);




}
