package com.example.sky.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView processTextview,resultTextview;
Button  button0,button1,button2,button3,button4,button5,button6,
        button7,button8,button9,button_add,button_sub,button_mul,
        button_div,button_modulus,button_dot,button_equal,button_clean,button_back;

String value,ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processTextview=(TextView)findViewById(R.id.input);
        resultTextview=(TextView)findViewById(R.id.result);

        processTextview.setText("");
        resultTextview.setText("");

        button0=(Button)findViewById(R.id.button_0);
        button1=(Button)findViewById(R.id.button_1);
        button2=(Button)findViewById(R.id.button_2);
        button3=(Button)findViewById(R.id.button_3);
        button4=(Button)findViewById(R.id.button_4);
        button5=(Button)findViewById(R.id.button_5);
        button6=(Button)findViewById(R.id.button_6);
        button7=(Button)findViewById(R.id.button_7);
        button8=(Button)findViewById(R.id.button_8);
        button9=(Button)findViewById(R.id.button_9);
        button_add=(Button)findViewById(R.id.button_add);
        button_sub=(Button)findViewById(R.id.button_sub);
        button_mul=(Button)findViewById(R.id.button_mul);
        button_div=(Button)findViewById(R.id.button_div);
        button_modulus=(Button)findViewById(R.id.button_modulus);
        button_dot=(Button)findViewById(R.id.button_dot);
        button_equal=(Button)findViewById(R.id.button_equal);
        button_clean=(Button)findViewById(R.id.button_clean);
        button_back=(Button)findViewById(R.id.button_back);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_mul.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_modulus.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_clean.setOnClickListener(this);
        button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button_clean)
        {
            processTextview.setText("");
            resultTextview.setText("");
        }
        if(v.getId()==R.id.button_back)
        {
            value=processTextview.getText().toString();
            if(value.length()>0) {
                value = value.substring(0, value.length() - 1);
                processTextview.setText(value);
            }
        }

        /*number button */
        if(v.getId()==R.id.button_0)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"0");
        }
        if(v.getId()==R.id.button_1)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"1");
        }
        if(v.getId()==R.id.button_2)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"2");
        }
        if(v.getId()==R.id.button_3)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"3");
        }
        if(v.getId()==R.id.button_4)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"4");
        }
        if(v.getId()==R.id.button_5)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"5");
        }
        if(v.getId()==R.id.button_6)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"6");
        }
        if(v.getId()==R.id.button_7)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"7");
        }
        if(v.getId()==R.id.button_8)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"8");
        }
        if(v.getId()==R.id.button_9)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"9");
        }


        /*operator button*/
        if(v.getId()==R.id.button_add)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"+");
        }
        if(v.getId()==R.id.button_sub)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"-");
        }
        if(v.getId()==R.id.button_mul)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"x");
        }
        if(v.getId()==R.id.button_div)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"÷");
        }
        if(v.getId()==R.id.button_dot)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+".");
        }
        if(v.getId()==R.id.button_modulus)
        {
            value=processTextview.getText().toString();
            processTextview.setText(value+"%");
        }


        /*Equal Button*/
        if(v.getId()==R.id.button_equal)
        {
            value=processTextview.getText().toString();
            value=value.replaceAll("÷","/");
            value=value.replaceAll("x","*");
            value=value.replaceAll("%","/100");
            Context context= Context.enter();
            context.setOptimizationLevel(-1);
            String result="";
            try
            {
                Scriptable scope=context.initStandardObjects();
                result = context.evaluateString(scope,value,"JavaScript",1,null).toString();

            }catch (Exception e)
            {
                result="Error!";
            }
            resultTextview.setText(result);
            ans=result;

        }

            }
    }

