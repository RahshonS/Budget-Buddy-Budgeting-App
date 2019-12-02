package edu.temple.budgetbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperPayment extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "payment.db";
    public static final String TABLE_NAME = "activity";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "AMOUNT";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "WHAT_PURCHASE";

    public DBHelperPayment(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, AMOUNT REAL, DESCRIPTION TEXT, WHAT_PURCHASE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String amount,String desc, String purchase) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,amount);
        contentValues.put(COL_3,desc);
        contentValues.put(COL_4,purchase);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
