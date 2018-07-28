package com.example.maggie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private static final String HABIT_NAME = "habit_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void ready(View view){
        Intent secondIntent = new Intent(this, ThirdActivity.class);

        secondIntent.putExtra(HABIT_NAME, this.getHabit(view));

        startActivity(secondIntent);
    }

    public String getHabit(View view){
        EditText editText = (EditText) findViewById(R.id.habitInput);
        String showString = editText.getText().toString();
        return showString;
    }
}
