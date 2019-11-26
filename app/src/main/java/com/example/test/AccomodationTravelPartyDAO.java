package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AccomodationTravelPartyDAO extends CruiseDataBase{

public AccomodationTravelPartyDAO (Context context) {super (context);}

//Creating queries for Page selection activity, it will be in the Accomodation Travel Party

    public long pageSelectionOption (AccomodationTravelPartyEntity accomodationTravelPartyEntity){
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("roomId",accomodationTravelPartyEntity.getRoomId());
        contentValues.put("dateId",accomodationTravelPartyEntity.getDateId());
        contentValues.put("destinationId",accomodationTravelPartyEntity.getDestinationId());
        contentValues.put("UserId",accomodationTravelPartyEntity.getUserId());
        contentValues.put("stateroomQtd",accomodationTravelPartyEntity.getStateroomQtd());
        contentValues.put("adultsQtd",accomodationTravelPartyEntity.getAdultsQtd());
        contentValues.put("childrenQtd",accomodationTravelPartyEntity.getChildrenQtd());
        contentValues.put("childrenAge",accomodationTravelPartyEntity.getChildrenAge());
        contentValues.put("acessibleRoom",accomodationTravelPartyEntity.isAcessibleRoom());
        contentValues.put("childrenPrice",accomodationTravelPartyEntity.getChildrenPrice());

        long storeaccomodationpart = myData.insert("ACOMODATION_TRAVELPARTY",null,contentValues);
        return storeaccomodationpart;




    }


}
