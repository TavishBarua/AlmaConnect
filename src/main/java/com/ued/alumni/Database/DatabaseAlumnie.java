package com.ued.alumni.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Android Developer on 7/23/2017.
 */

public class DatabaseAlumnie extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "myDatabaseAlumnie";
    // Contacts table name
    private static final String TABLE_TOPIC = "feed";
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_TIME = "time";
    private static final String KEY_DESCRIPTION = "description";

    public DatabaseAlumnie(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String CREATE_FEED_TABLE="CREATE TABLE IF EXIST "+TABLE_TOPIC+ "("
               + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
               + KEY_USERNAME + " VARCHAR ,"
               + KEY_TIME + " VARCHAR"
               + KEY_DESCRIPTION + " VARCHAR"+")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
