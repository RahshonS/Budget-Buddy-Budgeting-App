package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class payment_activity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    private static final String TAG = "payment_activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);
        userInput = (EditText) findViewById(R.id.amountText);
        //userInput = (EditText) findViewById(R.id.amountText);
        Button transportation3 = (Button) findViewById(R.id.transportation3);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener ourOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString();
                result = result + "\n";
                textView.append(result);
                userInput.setText("");
            }

        };
        transportation3.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");

    }
}
