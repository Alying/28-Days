package com.example.maggie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private static final String HABIT_NAME = "habit_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        showHeader();
    }

    public void showHeader(){
        //TextView headerView = (TextView) findViewById(R.id.habitHeader);
        TextView headingView = (TextView) findViewById(R.id.habitHeader);
        String header = getIntent().getStringExtra(HABIT_NAME);
        headingView.setText(header);
    }
}
