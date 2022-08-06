package com.example.bmi;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText h;                //宣告全域變數
    EditText w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h = (EditText)findViewById(R.id.et1);
        w = (EditText)findViewById(R.id.et2);
        Button submit = (Button)findViewById(R.id.button4);

        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {

                if ( !("".equals(h.getText().toString())
                        || "".equals(w.getText().toString())) )
                {
                    float fh = Float.parseFloat(h.getEditableText().toString());
                    float fw = Float.parseFloat(w.getEditableText().toString());
                    float fresult;
                    TextView result = (TextView)findViewById(R.id.tv3);
                    fh = fh/100;
                    fh = fh*fh;

                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    fresult = fw/fh;
                    result.setText(nf.format(fw/fh) +"");
                    TextView dia = (TextView)findViewById(R.id.tv4);


                    if (fresult<18.5)
                        dia.setText("體重過輕");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("正常範圍");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("過    重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖        ");
                }
            }
        });
    }
}