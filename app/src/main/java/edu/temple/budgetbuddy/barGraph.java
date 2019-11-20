package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class barGraph extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        barChart = (BarChart)findViewById(R.id.bargraph);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(44f, 0));
        barEntries.add(new BarEntry(21f, 1));
        barEntries.add(new BarEntry(55f, 2));
        barEntries.add(new BarEntry(43f, 3));
        barEntries.add(new BarEntry(28f, 4));
        barEntries.add(new BarEntry(41f, 5));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");


        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("April");
        theDates.add("May");
        theDates.add("June");
        theDates.add("July");
        theDates.add("August");
        theDates.add("Sept");

        BarData barData = new BarData(barDataSet, barDataSet);
        barChart.setData(barData);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
    }
}
