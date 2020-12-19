package com.example.navigationdrawerassignmentmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class QuizQuestion{
    public String question;
    public String Option1 ;
    public String Option2 ;
    public String Option3 ;
    public String Option4 ;
}

public class QuizActivity extends AppCompatActivity {
    int correct;
    TextView[] textView;

    RadioGroup[] radioGroup;
    Button SubmitQuizbtn;
    private String [] CorrectAnswer={"Mt. McKinley","skin","United States","blood","hydrogen and helium","HTML","Gypsum","learning","walked","Homonym","websites","HTTP","machine learning","glass","hyperlinks"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        SubmitQuizbtn=(Button) findViewById(R.id.submitbtn);
        textView=new TextView[]{findViewById(R.id.question1_textview),findViewById(R.id.question2_textview),findViewById(R.id.question3_textview),findViewById(R.id.question4_textview),findViewById(R.id.question5_textview),findViewById(R.id.question6_textview),findViewById(R.id.question7_textview),findViewById(R.id.question8_textview),
                findViewById(R.id.question9_textview),findViewById(R.id.question10_textview),findViewById(R.id.question11_textview),findViewById(R.id.question12_textview),findViewById(R.id.question13_textview),findViewById(R.id.question14_textview),findViewById(R.id.question15_textview)};
        radioGroup=new RadioGroup[]{findViewById(R.id.radigrp1),findViewById(R.id.radigrp2),findViewById(R.id.radigrp3),findViewById(R.id.radigrp4),findViewById(R.id.radigrp5),findViewById(R.id.radigrp6),findViewById(R.id.radigrp7),
                findViewById(R.id.radigrp8),findViewById(R.id.radigrp9),findViewById(R.id.radigrp10),findViewById(R.id.radigrp11),findViewById(R.id.radigrp12),findViewById(R.id.radigrp13),findViewById(R.id.radigrp14),findViewById(R.id.radigrp15)};
        String []filedata = getResources().getStringArray(R.array.quiz);
        List<QuizQuestion> list= Collections.synchronizedList(new ArrayList<QuizQuestion>());
        for(int i = 0; i<filedata.length ; i++){
            String [] q= filedata[i].split("\\!");
            QuizQuestion questions=new QuizQuestion();
            questions.question=q[0];
            questions.Option1=q[1];
            questions.Option2=q[2];
            questions.Option3=q[3];
            questions.Option4=q[4];
            list.add(i,questions);

        }


        for(int i=0;i<15;i++){
            setQuestion(textView[i],radioGroup[i],list,i);
        }

        SubmitQuizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<15;i++){
                    int chk=radioGroup[i].getCheckedRadioButtonId();
                    RadioButton radiobtn=findViewById(chk);
                    if(CorrectAnswer[i].equals(radiobtn.getText().toString())){
                        correct++;
                    }
                }
                Intent resultactivity=new Intent(QuizActivity.this,ResultActivity.class);
                resultactivity.putExtra("correct",Integer.toString(correct));
                startActivity(resultactivity);
            }
        });





    }
    public void setQuestion(TextView textview1,RadioGroup radiogrp,List<QuizQuestion>list,int index){
        String qno = Integer.toString(index+1);
        textview1.setText(qno + ". " + list.get(index).question);
        for (int i = 0; i < radiogrp.getChildCount();i++) {
            if(i == 0)
            {
                ((RadioButton) radiogrp.getChildAt(i)).setText(list.get(index).Option1);
            }
            if(i == 1)
            {
                ((RadioButton) radiogrp.getChildAt(i)).setText(list.get(index).Option2);
            }
            if(i == 2)
            {
                ((RadioButton) radiogrp.getChildAt(i)).setText(list.get(index).Option3);
            }
            if(i == 3)
            {
                ((RadioButton) radiogrp.getChildAt(i)).setText(list.get(index).Option4);
            }
        }
    }
}