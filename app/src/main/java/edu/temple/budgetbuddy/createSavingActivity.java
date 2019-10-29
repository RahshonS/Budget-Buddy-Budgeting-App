package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.BigDecimal;

public class createSavingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_saving);

        String[] spinneritems= {"Basic (10%)","Casual (15%)","Intense (25%)","E X T R E M E (50%)"};

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

                String income = incomeText.getText().toString();
                Double dIncome = Double.parseDouble(income);
                boolean fail = (BigDecimal.valueOf(dIncome).scale() > 2);

                if (nameText.getText().toString().matches("") ||
                        incomeText.getText().toString().matches("") ||
                        spinner.getCount() == 0) {
                    Toast.makeText(createSavingActivity.this, "You left an empty field!", Toast.LENGTH_SHORT).show();
                }
                else if(fail){
                    Toast.makeText(createSavingActivity.this, "Only 2 decimal places allowed in Monthly Income", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent mainIntent = new Intent(getBaseContext(),MainActivity.class);
                    mainIntent.putExtra("profileName", nameText.getText().toString());
                    startActivity(mainIntent);
                }
            }
        });
    }
}
