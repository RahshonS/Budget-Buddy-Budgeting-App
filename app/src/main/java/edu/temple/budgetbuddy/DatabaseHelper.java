package edu.temple.budgetbuddy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Budget.db";
    public static final String PROFILE_TABLE = "Profile";
    public static final String PCOL_1 = "ID";
    public static final String PCOL_2 = "Income";
    public static final String PCOL_3 = "name";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + PROFILE_TABLE +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, INCOME INTEGER, NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PROFILE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
