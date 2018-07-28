package com.example.maggie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void start(View view){
        Intent startIntent = new Intent(this, ThirdActivity.class);
        startActivity(startIntent);
    }

    public String getHabit(View view){
        EditText editText = (EditText) findViewById(R.id.habitInput);
        String showString = editText.getText().toString();
        return showString;
    }
}
