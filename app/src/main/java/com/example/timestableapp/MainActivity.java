package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNum) {
        ArrayList<String> timesTableContent = new ArrayList<>();

        for(int i = 1; i<=10; i++) {
            timesTableContent.add(Integer.toString(i * timesTableNum));
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timeTablesSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);

        int max = 20;
        int startNum = 10;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startNum);

        generateTimesTable(startNum);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // just so that we have option to change min anytime
                int min = 1;
                int timesTableNum;

                if(progress < min) {
                    timesTableNum = min;
                    timesTablesSeekBar.setProgress(min);
                } else {
                    timesTableNum = progress;
                }
                generateTimesTable(timesTableNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}