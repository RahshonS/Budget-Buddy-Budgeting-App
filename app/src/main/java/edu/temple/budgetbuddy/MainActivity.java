package edu.temple.budgetbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> strList = new ArrayList<String>();
    DBHelperPayment myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DBHelperPayment(this);
        myDb.insertSomeData();

        if (getIntent().getStringExtra("profileName") == null) {
        } else {
            strList.add(getIntent().getStringExtra("profileName"));
        }

        String string = getString(R.string.welcome_text);
        String string1 = getString(R.string.prog);
        String string2 = getString(R.string.expense);
        String string3 = getString(R.string.hist);


        Button newTemplate = (Button) findViewById(R.id.newTemplate);
        Button payment = (Button) findViewById(R.id.payment);
        Button progress = (Button) findViewById(R.id.progress);
        Button history = (Button) findViewById(R.id.hist);

        newTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), createSavingActivity.class);
                startActivity(intent);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), payment_activity.class);
                startActivity(intent);
            }
        });

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), viewProgressActivity.class);
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID: " + res.getString(0) + "\n");
                    buffer.append("Amount: " + res.getString(1) + "\n");
                    buffer.append("Expense Description: " + res.getString(2) + "\n");
                    buffer.append("Purchase Category: " + res.getString(3) + "\n\n");
                }
                // Show all data
                showMessage("Data", buffer.toString());
            }
        });
    }

        public void showMessage(String title,String Message){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();
        }
}

