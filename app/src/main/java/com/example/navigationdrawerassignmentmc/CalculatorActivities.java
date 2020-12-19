package com.example.navigationdrawerassignmentmc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivities extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnclear,btnequal,btnplus,btndivide,btnmultiply,btnsub;
    private EditText result;
    float val1,val2;
    boolean addition,multiplication,division,sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_activities);
        result=(EditText)  findViewById(R.id.text_id);
        btn0=(Button) findViewById(R.id.btn0);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);
        btn6=(Button) findViewById(R.id.btn6);
        btn7=(Button) findViewById(R.id.btn7);
        btn8=(Button) findViewById(R.id.btn8);
        btn9=(Button) findViewById(R.id.btn9);
        btnplus=(Button) findViewById(R.id.btn_add);
        btnmultiply=(Button) findViewById(R.id.btn_multiply);
        btndivide=(Button) findViewById(R.id.btn_divide);
        btnsub=(Button) findViewById(R.id.btn_subtract);
        btnequal=(Button) findViewById(R.id.btnequal);
        btnclear=(Button) findViewById(R.id.btnclear);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"0");
            }

        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"2");
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"3");
            }
        });



        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"4");
            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"5");
            }
        });


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"6");
            }
        });



        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"7");
            }
        });



        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"8");
            }
        });



        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"9");
            }
        });


        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result==null)
                {
                    result.setText("");
                }
                else{
                    val1= Float.parseFloat(result.getText()+"");
                    addition=true;
                    result.setText(null);
                }
            }
        });


        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(result.getText()+"");
                multiplication=true;
                result.setText(null);
            }
        });



        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(result.getText()+"");
                sub=true;
                result.setText(null);
            }
        });

        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(result.getText()+"");
                division=true;
                result.setText(null);
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2=Float.parseFloat(result.getText()+"");
                if(addition==true){
                    result.setText(val1+val2+"");
                    addition=false;
                }

                else if(sub==true){
                    result.setText(val1-val2+"");
                    sub=false;
                }
                else if(multiplication==true){
                    result.setText(val1*val2+"");
                    multiplication=false;
                }
                else if(division==true){
                    result.setText(val1/val2+"");
                    division=false;
                }
            }
        });

    }
}