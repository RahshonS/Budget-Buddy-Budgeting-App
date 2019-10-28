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

        Button newTemplate = (Button) findViewById(R.id.button4);
        Button payment = (Button) findViewById(R.id.button);
        Button progress = (Button) findViewById(R.id.button2);
        Button settings = (Button) findViewById(R.id.button3);

        newTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), createSavingActivity.class);
                startActivity(intent);
            }
        });
    }
}
