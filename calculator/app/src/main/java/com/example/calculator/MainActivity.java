package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button add,subtract,multiply,divide,equal,delete,clear,point;
    private Button one,two,three,four,five,six,seven,eight,nine,zero;
    private EditText showtext;
    private String OperateSum="";
    private char Operator;
    private double num1=0,num2=0,sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView()
    {
        one=(Button) findViewById(R.id.one);
        two=(Button) findViewById(R.id.two);
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);
        six=(Button) findViewById(R.id.six);
        seven=(Button) findViewById(R.id.seven);
        eight=(Button) findViewById(R.id.eight);
        nine=(Button) findViewById(R.id.nine);
        zero=(Button) findViewById(R.id.zero);

        add=(Button) findViewById(R.id.add);
        subtract=(Button) findViewById(R.id.subtract);
        multiply=(Button) findViewById(R.id.multiply);
        divide=(Button) findViewById(R.id.divide);
        delete=(Button) findViewById(R.id.delete);
        clear=(Button) findViewById(R.id.clear);
        equal=(Button) findViewById(R.id.equal);
        point=(Button) findViewById(R.id.point);
        showtext=(EditText) findViewById(R.id.text);

        showtext.setCursorVisible(false);
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        clear.setOnClickListener(this);
        point.setOnClickListener(this);
        showtext.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                OperateSum=AddSum('1');
                showtext.setText(OperateSum);
                break;
            case R.id.two:
                OperateSum=AddSum('2');
                showtext.setText(OperateSum);
                break;
            case R.id.three:
                OperateSum=AddSum('3');
                showtext.setText(OperateSum);
                break;
            case R.id.four:
                OperateSum=AddSum('4');
                showtext.setText(OperateSum);
                break;
            case R.id.five:
                OperateSum=AddSum('5');
                showtext.setText(OperateSum);
                break;
            case R.id.six:
                OperateSum=AddSum('6');
                showtext.setText(OperateSum);
                break;
            case R.id.seven:
                OperateSum=AddSum('7');
                showtext.setText(OperateSum);
                break;
            case R.id.eight:
                OperateSum=AddSum('8');
                showtext.setText(OperateSum);
                break;
            case R.id.nine:
                OperateSum=AddSum('9');
                showtext.setText(OperateSum);
                break;
            case R.id.zero:
                OperateSum=AddSum('0');
                showtext.setText(OperateSum);
                break;

            case R.id.add:
                OperateSum=AddSum('+');
                Operator='+';
                showtext.setText(OperateSum);
                break;
            case R.id.subtract:
                OperateSum=AddSum('-');
                Operator='-';
                showtext.setText(OperateSum);
                break;
            case R.id.multiply:
                OperateSum=AddSum('*');
                Operator='*';
                showtext.setText(OperateSum);
                break;
            case R.id.divide:
                OperateSum=AddSum('/');
                Operator='/';
                showtext.setText(OperateSum);
                break;
            case R.id.point:
                OperateSum=AddSum('.');
                showtext.setText(OperateSum);
                break;
            case R.id.delete:
                if(OperateSum.length()>=1)
                {
                    OperateSum=OperateSum.substring(0,OperateSum.length()-1);
                }
                showtext.setText(OperateSum);
                break;
            case R.id.clear:
                OperateSum="";
                num1=0;
                num2=0;
                sum=0;
                Operator=' ';
                showtext.setText(OperateSum);
                break;
            case R.id.equal:
                if(CheckInput(OperateSum))
                {
                    OperateSum=OperateSum+"="+String.valueOf(equals(OperateSum));
                    showtext.setText(OperateSum);
                    OperateSum=String.valueOf(sum);
                }
                else
                {
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;

        }
    }
    public String AddSum(char c)
    {
        OperateSum=OperateSum+String.valueOf(c);
        return OperateSum;
    }

    public boolean CheckInput(String OperateSum)
    {
        int countOperator=0,firstOperatorPosition=0,leftPoint=0,rightPoint=0;
        char[] chars = OperateSum.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='*'||chars[i]=='/'||chars[i]=='+'||chars[i]=='-'){
                countOperator++;
            }
        }
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='.'){
                leftPoint++;
            }
            if(chars[i]=='*'||chars[i]=='/'||chars[i]=='+'||chars[i]=='-'){
                firstOperatorPosition=i;
                break;
            }
        }
        for (int i=firstOperatorPosition;i<chars.length;i++){
            if(chars[i]=='.'){
                rightPoint++;
            }
        }

        if(OperateSum.length()<=2)
        {
            return false;
        }
        if(OperateSum.indexOf(Operator, 1)==-1)
        {
            return false;
        }

        if(OperateSum.endsWith(String.valueOf(Operator)))
        {
            return false;
        }
        if(countOperator>1){
            return false;
        }
        if(leftPoint>1){
            return false;
        }
        if (rightPoint>1){
            return false;
        }
        return true;
    }
    public double equals(String OperateSum)
    {
        int indexOfOperator=0;
        indexOfOperator=OperateSum.indexOf(Operator,1);
        if(OperateSum.length()>=3)
        {
            num1=Double.parseDouble(OperateSum.substring(0, indexOfOperator));
            num2=Double.parseDouble(OperateSum.substring(indexOfOperator + 1, OperateSum.length()));
        }
        switch (Operator)
        {
            case '+':
                sum=num1+num2;
                break;
            case '-':
                sum=num1-num2;
                break;
            case '*':
                sum=num1*num2;
                break;
            case '/':
                if(num2!=0)
                {
                    sum=num1/num2;
                }
                else
                {
                    sum=0;
                    Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
        return sum;
    }
}