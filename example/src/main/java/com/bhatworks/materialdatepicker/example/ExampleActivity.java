package com.bhatworks.materialdatepicker.example;

import com.bhatworks.materialdatepicker.DatePickerFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ExampleActivity extends AppCompatActivity {

    public static final String PICKER_TAG = ExampleActivity.class.getName() + "-datePicker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(transaction, PICKER_TAG);
    }
}
