package com.example.maggie.helloworld;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.lang.Integer;
import java.util.ArrayList;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    private static final String HABIT_NAME = "habit_name";
    private static final String TAG = "MainActivity";

    private TextView thedate;
    private Button btngocalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thedate = (TextView) findViewById(R.id.date);
        btngocalendar = (Button) findViewById(R.id.btngocalendar);

        Intent incoming = getIntent();
        String date = incoming.getStringExtra("date");
        thedate.setText(date);

        btngocalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
    }

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

    public void newStreak(){
        //TextView headerView = (TextView) findViewById(R.id.habitHeader);
        TextView count = (TextView) findViewById(R.id.streakNum);
        count.setText(this.updateStreak());
    }

    public void makeAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
        builder.setMessage("Were you successful today?");

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
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
