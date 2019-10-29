package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> strList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] array = null;
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        if(getIntent().getStringExtra("profileName") == null){
        }else{
        strList.add(getIntent().getStringExtra("profileName"));
        array = strList.toArray(new String[strList.size()]);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, array);
            spinner.setAdapter(adapter);
        }

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

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), payment_activity.class);
                startActivity(intent);
            }
        });
    }
}
