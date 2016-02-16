package com.example.atitude6430.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Atitude6430 on 2016-02-16.
 */
public class TableOperations extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DATABASE1";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE "+NewElement.Table1.TABLE_NAME
            +"("+NewElement.Table1.NAME+" TEXT,"
            +NewElement.Table1.MOBILE
            +" TEXT,"+NewElement.Table1.EMAIL+" TEXT);";

    public TableOperations(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("DATABASE","created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("DATABESE","TABLE CREATED");
    }
    public void addInformations(String name, String mobile, String email, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewElement.Table1.NAME,name);
        contentValues.put(NewElement.Table1.MOBILE,mobile);
        contentValues.put(NewElement.Table1.EMAIL,email);
        db.insert(NewElement.Table1.TABLE_NAME, null, contentValues);
        Log.d("DATABESE", "row added");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getInformations (SQLiteDatabase db){
        //metoda do zwracania obiektów
        Cursor cursor;
        String[] projections = {NewElement.Table1.NAME,NewElement.Table1.MOBILE,NewElement.Table1.EMAIL}; //innymi słowy nazwy kolumn
                cursor = db.query(NewElement.Table1.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }
}
