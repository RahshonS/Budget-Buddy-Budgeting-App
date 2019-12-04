package edu.temple.budgetbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class pieGraph extends AppCompatActivity {

    public static String TAG = "PieActivity";
    public float x = 25.3f;

    public float[] yData = {x, 10.2f, 42.32f, 55.1f, 53.78f, 13.64f, 23.1f};

    public String[] xData = {"Food", "Trans", "Online", "Clothing", "School Supplies", "House Supplies", "Misc"};

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_graph);

        pieChart = (PieChart) findViewById(R.id.pieChart);

        //pieChart.setDescription("Spending Categories");
        pieChart.setRotation(0);
        pieChart.setHoleRadius(20f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Expenditures");
        pieChart.setCenterTextSize(8);
        //pieChart.setDrawEntryLabels(true);

        addDataSet();
    }

    private void addDataSet(){
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i] , xData[i]));
        }

            /*
            for(int i = 0; i < xData.length; i++){
                xEntrys.add(xData[i]);
            }
             */

        //Data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Expenses");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colours
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#008BB4"));
        colors.add(Color.parseColor("#00A3B4"));
        //colors.add(Color.parseColor("#2572B3"));
        colors.add(Color.parseColor("#3D4645"));
        colors.add(Color.parseColor("#00B065"));
        colors.add(Color.parseColor("#0083B1"));
        colors.add(Color.parseColor("#00B08A"));
        colors.add(Color.parseColor("#5AFFDC"));

        pieDataSet.setColors(colors);

        //add legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        //Legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    /*
    pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
        @Override
        public void onValueSelected(Entry e, Highlight h) {
            Log.d(TAG, "onValueSelected: Value Select from chart");
            Log.d(TAG, "onValueSelected: " + e.toString());   //show what e looks like
            Log.d(TAG, "onValueSelected: " + h.toString());   //show what h looks like

            int pos1 = e.toString().indexOf("(sum): ");
            String expenses = e.toString().substring(pos1 + 7);


            for(int i = 0; i < yData.length; i++){
                if(yData[i] == Float.parseFloat(expenses)){
                    pos1 = i;
                    break;
                }
            }
            String category = xData[pos1 + 1];
            Toast.makeText(this, "Category " + category + "\n" + "Amount Spent: $" +
                    expenses, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected() {

        }
    });

     */

}

