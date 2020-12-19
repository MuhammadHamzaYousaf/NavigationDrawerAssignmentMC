package com.example.navigationdrawerassignmentmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button Exit,Again;
    int correctans=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textViewResult=findViewById(R.id.textviewresult);
        Exit=(Button)findViewById(R.id.exitquiz);
        Again=(Button)findViewById(R.id.btnaginquiz);
        textViewResult.setText("Your Score is :"+getIntent().getStringExtra("correct"));

        Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent againquiz=new Intent(ResultActivity.this,QuizActivity.class);
                startActivity(againquiz);
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                System.exit(1);
            }
        });
    }
}