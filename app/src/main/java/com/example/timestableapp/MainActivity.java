package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timeTablesSeekBar);

        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);

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

                ArrayList<String> timesTableContent = new ArrayList<>();
                ListView timesTablesListView = findViewById(R.id.timesTablesListView);

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