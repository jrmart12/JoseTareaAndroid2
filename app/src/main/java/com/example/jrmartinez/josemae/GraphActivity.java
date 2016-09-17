package com.example.jrmartinez.josemae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;


public class GraphActivity extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        barChart=(BarChart)findViewById(R.id.bargraph);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        if(ransactionActivity.o.equals("Ingresos")) {
            barEntries.add(new BarEntry(ProfileActivity.numero, 0));
        }
        else {
            barEntries.add(new BarEntry(ProfileActivity.numero, 1));
        }

        BarDataSet barDataSet = new BarDataSet(barEntries,"DETALLE HISTORICO DE ["+SignUpActivity.EMAIL_KEY+"]");

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("Ingresos");
        theDates.add("Egresos");

        BarData theData = new BarData(theDates,barDataSet);
        barChart.setData(theData);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleXEnabled(true);
    }


}
