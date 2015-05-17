package com.bhatworks.materialdatepicker.example;

import com.bhatworks.materialdatepicker.DatePicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        if (savedInstanceState == null) {
            DatePicker.builder()
                    .fragmentManager(getSupportFragmentManager())
                    .theme(R.style.AppTheme_DatePicker)
                    .build()
                    .show();
        }
    }
}
