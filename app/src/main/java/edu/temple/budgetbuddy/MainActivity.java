package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> strList = new ArrayList<String>();
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getStringExtra("profileName") == null){
        }else{
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
                Intent intent = new Intent(getBaseContext(), expenseHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
