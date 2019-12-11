package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class payment_activity extends AppCompatActivity {
    DBHelperPayment myDB;
    EditText amountText, desc;
    Button transportation3;
    Button foodButton;
    Button partyButton;
    Button other;

    private EditText userInput;
    private static final String TAG = "payment_activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);
        myDB = new DBHelperPayment(this);
        myDB.insertSomeData();

        amountText = (EditText)findViewById(R.id.amountText);
        desc = (EditText)findViewById(R.id.desc);
        transportation3 = (Button)findViewById(R.id.transportation3);
        foodButton = (Button)findViewById(R.id.foodButton);
        partyButton = (Button)findViewById(R.id.partyButton);
        other = (Button)findViewById(R.id.other);
        AddTransportaion();
        AddFood();
        AddParty();
        AddOther();
    }
    public  void AddTransportaion() {
        transportation3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String income = amountText.getText().toString();
                        Double dIncome = Double.parseDouble(income);
                        boolean fail = (BigDecimal.valueOf(dIncome).scale() > 2);

                        if (amountText.getText().toString().matches("") ||
                                desc.getText().toString().matches("")) {
                            Toast.makeText(payment_activity.this, "You left an empty field!", Toast.LENGTH_SHORT).show();
                        } else if(fail){
                            Toast.makeText(payment_activity.this, "Only 2 decimal places allowed in Monthly Income", Toast.LENGTH_SHORT).show();
                        } else {
                            String transport = "Transportation Cost";
                            boolean isInserted = myDB.insertData(amountText.getText().toString(),
                                    desc.getText().toString(),
                                    transport);
                            if (isInserted == true)
                                Toast.makeText(payment_activity.this, "Data Inserted ^-^", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(payment_activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public  void AddFood() {
        foodButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String income = amountText.getText().toString();
                        Double dIncome = Double.parseDouble(income);
                        boolean fail = (BigDecimal.valueOf(dIncome).scale() > 2);

                        if (amountText.getText().toString().matches("") ||
                                desc.getText().toString().matches("")) {
                            Toast.makeText(payment_activity.this, "You left an empty field!", Toast.LENGTH_SHORT).show();
                        } else if(fail){
                            Toast.makeText(payment_activity.this, "Only 2 decimal places allowed in Monthly Income", Toast.LENGTH_SHORT).show();
                        } else {
                            String food = "Food Cost";
                            boolean isInserted = myDB.insertData(amountText.getText().toString(),
                                    desc.getText().toString(),
                                    food);
                            if (isInserted == true)
                                Toast.makeText(payment_activity.this, "Data Inserted ^-^", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(payment_activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public  void AddParty() {
        partyButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String income = amountText.getText().toString();
                        Double dIncome = Double.parseDouble(income);
                        boolean fail = (BigDecimal.valueOf(dIncome).scale() > 2);

                        if (amountText.getText().toString().matches("") ||
                                desc.getText().toString().matches("")) {
                            Toast.makeText(payment_activity.this, "You left an empty field!", Toast.LENGTH_SHORT).show();
                        } else if(fail){
                            Toast.makeText(payment_activity.this, "Only 2 decimal places allowed in Monthly Income", Toast.LENGTH_SHORT).show();
                        } else {
                            String fun = "Fun";
                            boolean isInserted = myDB.insertData(amountText.getText().toString(),
                                    desc.getText().toString(),
                                    fun);
                            if (isInserted == true)
                                Toast.makeText(payment_activity.this, "Data Inserted ^-^", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(payment_activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public  void AddOther() {
        other.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String income = amountText.getText().toString();
                        Double dIncome = Double.parseDouble(income);
                        boolean fail = (BigDecimal.valueOf(dIncome).scale() > 2);

                        if (amountText.getText().toString().matches("") ||
                                desc.getText().toString().matches("")) {
                            Toast.makeText(payment_activity.this, "You left an empty field!", Toast.LENGTH_SHORT).show();
                        } else if(fail){
                            Toast.makeText(payment_activity.this, "Only 2 decimal places allowed in Monthly Income", Toast.LENGTH_SHORT).show();
                        } else {
                            String other = "Miscellaneous";
                            boolean isInserted = myDB.insertData(amountText.getText().toString(),
                                    desc.getText().toString(),
                                    other);
                            if (isInserted == true)
                                Toast.makeText(payment_activity.this, "Data Inserted ^-^", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(payment_activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}