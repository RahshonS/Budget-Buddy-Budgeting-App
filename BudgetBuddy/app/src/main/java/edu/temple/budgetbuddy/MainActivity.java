package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


    }

    public void openCreateActivity(){
        Intent intent = new Intent(this, createActivity.class);
        startActivity(intent);
    }
}
