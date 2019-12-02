package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.BigDecimal;

public class createSavingActivity extends AppCompatActivity {

    DBHelperSaving myDb;
    EditText nameText, incomeText;
    Button button;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_saving);
        myDb = new DBHelperSaving(this);

        button = (Button) findViewById(R.id.createSavingsButton);
        nameText = (EditText) findViewById(R.id.nameEditText);
        incomeText = (EditText) findViewById(R.id.incomeEditText);
        spinner = (Spinner) findViewById(R.id.savingsPlanSpinner);
        String[] spinneritems = {"Basic (10%)", "Casual (15%)", "Intense (25%)", "E X T R E M E (50%)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(createSavingActivity.this, R.layout.support_simple_spinner_dropdown_item
                ,spinneritems);
        spinner.setAdapter(adapter);
        createProfile();
    }
    public  void createProfile() {
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
                else {
                    Intent mainIntent = new Intent(getBaseContext(), MainActivity.class);
                    mainIntent.putExtra("profileName", nameText.getText().toString());
                    startActivity(mainIntent);
                    boolean isInserted = myDb.insertData(nameText.getText().toString(),
                            incomeText.getText().toString());
                    if (isInserted == true)
                        Toast.makeText(createSavingActivity.this, "Profile Created", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(createSavingActivity.this, "Profile was not Created (✖╭╮✖)", Toast.LENGTH_LONG).show();
                }
            }
        });
            }
    }
