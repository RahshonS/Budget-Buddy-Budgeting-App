package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

public class expenseHistoryActivity extends AppCompatActivity {
    DBHelperSaving myDB;
    DBHelperPayment db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_history);
        myDB = new DBHelperSaving(this);
        db = new DBHelperPayment(this);
    }
}

