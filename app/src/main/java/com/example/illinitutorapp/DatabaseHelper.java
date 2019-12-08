package com.example.illinitutorapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Requests.db";
    public static final String TABLE_NAME = "request_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHONENUMBER";
    public static final String COL_4 = "COURSE";
    public static final String COL_5 = "LOCATION";
    public static final String COL_6 = "DATETIME";
    public static final String COL_7 = "NUMOFUSERS";
    public static final String COL_8 = "OPENCLOSED";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PHONENUMBER INTEGER," +
                "COURSE TEXT, LOCATION TEXT, DATETIME TEXT, NUMOFUSERS TEXT, OPENCLOSED TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String phonenumber, String course, String location,
        String datetime, String numofusers, String openclosed) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, phonenumber);
        contentValues.put(COL_4, course);
        contentValues.put(COL_5, location);
        contentValues.put(COL_6, datetime);
        contentValues.put(COL_7, numofusers);
        contentValues.put(COL_8, openclosed);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        }
        return true;
    }
}
