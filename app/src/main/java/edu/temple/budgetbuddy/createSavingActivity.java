package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class createSavingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_saving);

        String[] spinneritems= {"Basic Savings", "Casual Savings",
                "intense savings", "E X T R E M E S A V I N G S"};

        Button button = (Button) findViewById(R.id.createSavingsButton);
        final EditText nameText = (EditText) findViewById(R.id.nameEditText);
        final EditText incomeText = (EditText) findViewById(R.id.incomeEditText);
        final Spinner spinner = (Spinner) findViewById(R.id.savingsPlanSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(createSavingActivity.this, R.layout.support_simple_spinner_dropdown_item
        ,spinneritems);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameText.getText().toString().matches("") ||
                        incomeText.getText().toString().matches("") ||
                        spinner.getCount() == 0) {
                    Toast.makeText(createSavingActivity.this, "You left an empty field!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(createSavingActivity.this, "Successful Execution", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
