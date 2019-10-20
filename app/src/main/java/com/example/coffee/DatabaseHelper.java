package com.example.coffee;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Register.db";
    public static final String TABLE_NAME="SignUp_table";
    public static final String COL_1="FullName";
    public static final String COL_2="Username";
    public static final String COL_3="Email";
    public static final String COL_4="Password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" ( ID INTEGER PRIMARY KEY AUTOINCREMENT ,FullName TEXT, UserName TEXT, Email TEXT UNIQUE , Password PASSWORD)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fullname, String username, String email,String password) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, fullname);
        contentValues.put(COL_2, username);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4,password);
        long result= db.insert(TABLE_NAME,null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}

