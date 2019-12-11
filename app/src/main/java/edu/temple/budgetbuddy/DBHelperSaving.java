package edu.temple.budgetbuddy;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import androidx.annotation.Nullable;

public class DBHelperSaving extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "createSaving.db";
    public static final String TABLE_NAME = "profile";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "INCOME";
    public static final String COL_4 = "SAVING";

    private SQLiteDatabase mDb;


    public DBHelperSaving(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, INCOME REAL, SAVING REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String income) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,income);
        //contentValues.put(COL_4,saving);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public void insertSomeData() {
        insertData("June 2019","198.40");
        insertData("Sign-in Bonus","10000.00");
        insertData("October 2019","50.00");
        insertData("Gift Card - June 2018","100.00");
        insertData("January 2019","1943.00");
        insertData("Cash Gift - December 2018","650.00");
        insertData("February 2018","4000.00");
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
