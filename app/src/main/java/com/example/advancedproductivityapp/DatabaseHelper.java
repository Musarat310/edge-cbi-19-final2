package com.example.advancedproductivityapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String name = "Course";
    private static final String table_name = "Note_Table";
    private static final String id = "Id";
    private static final String name1 = "Note_Name";
    private static final String course_name = "Note_Details";

    public DatabaseHelper(@Nullable Context context) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_Table = "Create Table " +
                table_name + "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + name1 + "Text, "
                + course_name + "Text)";
        db.execSQL(Create_Table);
        Log.d("DATABASEOPERATION", "Table Created Successfully");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }
    public void addStudent(String name, String course_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name1, name);
        values.put(course_name, course_name);

        try{
            long result = db.insert(table_name,null,values);
            if(result==-1){
                Log.e("Database Error","failed to insert "+table_name);
            }
            else {
                Log.d("Database Op","Successfully created");
            }
        }
        catch (Exception e){
            Log.e("Database Error","Failed to insert");}
    }
}
