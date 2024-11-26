package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView result,finalResult;
    int num1, num2,res;
    String action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.resultView);
        finalResult=findViewById(R.id.finalResView);
        result.setText("");
        finalResult.setText("");
        action="";
        num1=0;
        num2=0;
        res=0;
    }

    public void numFunc(View view) {//when press any number
        if(!finalResult.getText().toString().isEmpty()){
            clearFunc(view);
        }
        Button button =(Button) view;
        if((action.isEmpty())){//if action is empty it's mean we read number to num1
            num1=num1*10 +Integer.parseInt(button.getText().toString());
        }
        else{//read the number to num2
            num2=num2*10 +Integer.parseInt(button.getText().toString());
        }
        result.append(button.getText().toString());
    }


    public void equalFunc(View view) {
        if(action.equals("+")) {//calculate the final result
            res= num1+num2;
        } else if (action.equals("-")) {
            res= num1-num2;
        } else if (action.equals("*")) {
            res = num1*num2;
        } else if (action.equals("/")) {
            res = num1/num2;
        }
        finalResult.setText(res+"");
    }

    public void actionFunc(View view) {//set the action
        Button button =(Button) view;
        action = button.getText().toString();
        result.append(button.getText().toString());
    }

    public void clearFunc(View view) {//clear button
        result.setText("");
        finalResult.setText("");
        action="";
        num1=0;
        num2=0;
        res=0;
    }
}