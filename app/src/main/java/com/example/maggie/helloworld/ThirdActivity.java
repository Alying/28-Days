package com.example.maggie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import java.lang.Integer;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    private static final String HABIT_NAME = "habit_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        showHeader();
        makeAlert();
    }

    public void showHeader(){
        //TextView headerView = (TextView) findViewById(R.id.habitHeader);
        TextView headingView = (TextView) findViewById(R.id.habitHeader);
        String header = getIntent().getStringExtra(HABIT_NAME);
        headingView.setText(header);
    }

    public void makeAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
        builder.setMessage("Were you successful today?");

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ThirdActivity.updateStreak();
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public int updateStreak(){
        TextView editText = (TextView) findViewById(R.id.streakNum);
        String showString = editText.getText().toString();
        int num = Integer.valueOf(showString);
        return num+1;
    }
}
