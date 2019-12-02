package edu.temple.budgetbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class viewProgressActivity extends AppCompatActivity {
    DBHelperSaving myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_progress);
        myDb = new DBHelperSaving(this);
        viewAll();
    }
    public void viewAll() {
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("Surname :"+ res.getString(2)+"\n");
            buffer.append("Marks :"+ res.getString(3)+"\n\n");
        }
        // Show all data
        showMessage("Data",buffer.toString());
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
