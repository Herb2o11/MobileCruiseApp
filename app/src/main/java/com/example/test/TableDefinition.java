package com.example.test;

public class TableDefinition {
//table USERS customized to follow the register page
// check the viability to add more colunms to users table eliminating  dates and destination tables
    public static final String SQL_CREATE_USER_TABLE =
            "CREATE TABLE USERS (  userid  integer primary key autoincrement, email text, name text, phone text, address text, password integer, creditCardInfo float )";

                    /*"(userId integer primary key, userName text, userLastName text, dateID integer foreign key," +
                    "creditCardInfo float, destinationID integer foreign key, departID integer foreign key, phone float, e-mail text, " +
                    "roomID integer foreign key, travelPartyID integer foreign key)"; */

    public static final String SQL_DELETE_USER_TABLE =
           "DROP TABLE IF EXISTS USERS";

    public static final String SQL_CREATE_DATES_TABLE =
            "CREATE TABLE DATE (dateID integer primary key, month text, depart_dates text)";

    public static final String  SQL_DELETE_DATES_TABLE =
            "DROP TABLE IF EXISTS DATE";

    public static final String SQL_CREATE_STATEROOM_TABLE =
            "CREATE TABLE STATEROOM( roomID integer primary key, roomCategory text, roomLocation text, roomPrice decimal," +
                    "roomType text)";

    public static final String SQL_DELETE_STATEROOM_TABLE =
            "DROP TABLE IF EXISTS STATEROOM";


    public static final String SQL_CREATE_DESTINATION_TABLE =
            " CREATE TABLE DESTINATION (destinationId integer primary key, destination text, destinationValue)";

    public static final String SQL_DELETE_DESTINATION_TABLE =
            "DELETE TABLE IF EXISTS DESTINATION";




/*
    public static final String SQL_CREATE_ACOMODATION_TRAVELPARTY_TABLE =
            "CREATE TABLE ACOMODATION_TRAVELPARTY(trvelPartyId integer primary key, stateRoomQtd integer, adultsQtd integer," +
                    "childrenQtd integer, childrenAge integer, accessibleRoom boolean, adultPrice float, childrenPrice float)";

    public static final String SQL_DELETE_ACOMODATION_TRAVELPARTY_TABLE =
            "DELETE TABLE IF EXISTS ACOMODATION_TRAVELPARTY =";

    public static final String SQL_CREATE_DEPART_TABLE =
            "CREATE TABLE DEPART( departId integer primary key, departLocation text)";

    public static final String SQL_DELETE_DEPART_TABLE =
            "DELETE TABLE IF EXISTS DEPART";

    public static final String SQL_CREATE_SHIPLOCATION_TABLE =
            "CREATE TABLE SHIPLOCATION( locationId integer primary key, shipDeckID integer, shipLocation text, locationAddPrice float)";
    //	shipDeckID  changed to integer

    public static final String SQL_DELETE_SHIPLOCATION_TABLE =
            "DELETE TABLE IF EXISTS SHIPLOCATION";

    public static final String SQL_CREATE_ADVENTUREPACK =
            "CREATE TABLE ADVENTUREPACK(advPackId integer primary key, activityName float, activityPrice float, activityId integer)";

    public static final String SQL_DELETE_ADVENTUREPACK =
            "DELETE TABLE IF EXISTS ADVENTUREPACK";

    public static final String SQL_CREATE_ORDER =
            "CREATE TABLE ORDER( orderId integer primary key, orderValue float,  foreign key advancedPackId references ADVENTUREPACK(advPackId ) on delete cascade , travelPartyId integer, foreign key locationId references SHIPLOCATION(locationId ) on delete cascade  , shipId integer )";

    public static final String SQL_DELETE_ORDER =
            " DELETE TABLE IF EXISTS ORDER";

    public static final String SQL_CREATE_PAYMENT =
            " CREATE TABLE PAYMENT(payId integer primary key, paymentMethod text, foreign key userId references USERS  ( userId ) on delete cascade ,  foreign key orderId references ORDER( orderId ) on delete cascade";

    public static final String SQL_DELETE_PAYMENT =
            "DELETE TABLE IF EXISTS PAYMENT ";


*/


}
