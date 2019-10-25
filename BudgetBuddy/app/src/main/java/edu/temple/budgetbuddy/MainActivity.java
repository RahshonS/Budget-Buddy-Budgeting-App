package edu.temple.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createButton = findViewById(R.id.createButton);
        Button addExpenseButton = findViewById(R.id.addExpenseButton);
        Button viewButton = findViewById(R.id.viewButton);


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateActivity();
            }
        });
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddExpenseActivity();
            }
        });
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewActivity();
            }
        });

    }

    public void openCreateActivity(){
        Intent intent = new Intent(this, createActivity.class);
        startActivity(intent);
    }

    public void openAddExpenseActivity(){
        Intent intent = new Intent(this, addExpenseActivity.class);
        startActivity(intent);
    }

    public void openViewActivity(){
        Intent intent = new Intent(this, viewActivity.class);
        startActivity(intent);
    }
}
