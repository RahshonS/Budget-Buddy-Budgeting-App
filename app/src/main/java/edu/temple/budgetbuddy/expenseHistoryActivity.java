package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.text.TextWatcher;

public class expenseHistoryActivity extends AppCompatActivity {
    DBHelperSaving myDB;
    DBHelperPayment db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_history);
        myDB = new DBHelperSaving(this);
        myDB.insertSomeData();
        db = new DBHelperPayment(this);
        db.insertSomeData();
        //displayListView();
    }
    /*private void displayListView() {
        SimpleCursorAdapter dataAdapter;
        Cursor cursor = myDB.fetchAll();

        // The desired columns to be bound
        String[] columns = new String[] {myDB.COL_1, myDB.COL_2, myDB.COL_3};

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.code,
                R.id.name,
                R.id.continent
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.list_profile,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
                String name =
                        cursor.getString(cursor.getColumnIndexOrThrow("NAME"));
                Toast.makeText(getApplicationContext(),
                        name, Toast.LENGTH_SHORT).show();

            }
        });

        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {
            SimpleCursorAdapter dataAdapter;

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return myDB.fetchByName(constraint.toString());
            }
        });*/
//}
}

