package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.os.DropBoxManager;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
public class lineGraph extends AppCompatActivity {

    LineChart lineChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_graph);

        lineChart = findViewById(R.id.lineChart);

        // lineChart.setOnChartGestureListener(MainActivity.this);
        // lineChart.setOnChartValueSelectedListener(MainActivity.this);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        int numDays = 30;
        float moneySpent = 0;

        for(int i = 0; i < numDays; i++){
            moneySpent = moneySpent + 5;
            if(i % 2 == 0){
                moneySpent = moneySpent + 16;
            }
            else if(i % 3 == 0){
                moneySpent = moneySpent + 11;
            }
            else if(i % 5 == 0){
                moneySpent = moneySpent + 4;
            }
            else{
                moneySpent = moneySpent + 0;
            }
            yValues.add(new Entry(i, moneySpent));
        }

        LineDataSet set1 = new LineDataSet(yValues, "Data Set 1");

        set1.setFillAlpha(110);
        LimitLine upper_limit = new LimitLine(550f, "Budget Limit");
        upper_limit.setLineWidth(5f);
        upper_limit.enableDashedLine(10f, 10f, 0f);
        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.LEFT_TOP);

        lineChart.getAxisRight().setEnabled(false);

        set1.setLineWidth(1f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        lineChart.setData(data);

        /*Setting x axis vals
        String[] values = new String[] {"Jan", "Feb", "Mar", "Apr", "May"};
        XAxis xaxis = lineChart.getXAxis();
        xaxis.setValueFormatter(new MyXAxisValueFormatter(values));
        xaxis.setGranularity(1f);
        */
    }
}