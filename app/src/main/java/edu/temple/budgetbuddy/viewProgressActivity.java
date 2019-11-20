package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_progress);

        Button viewPie = findViewById(R.id.viewPie);
        Button viewBar = findViewById(R.id.viewBar);
        Button viewLine = findViewById(R.id.viewLine);

        viewPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), pieGraph.class);
                startActivity(intent);
            }
        });

        viewLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), lineGraph.class);
                startActivity(intent);
            }
        });

        viewBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), barGraph.class);
                startActivity(intent);
            }
        });
    }
}
