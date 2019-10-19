package com.example.java.toolbarapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class SecondSignalActivity extends AppCompatActivity {

    private String fre;
    private SimpleChartView view;
    private EditText editTextfre;
    private Button button;
    private Button button_back2;
    private Three_confirm_Signal three_confirm_signal = Three_confirm_Signal.getInstance(SecondSignalActivity.this,"PSS1.txt");
    private int range ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        view = findViewById(R.id.simpleChartView2);
        editTextfre = findViewById(R.id.et_fre);
        button_back2 = findViewById(R.id.bt_back2);
        button = findViewById(R.id.bt);
        three_confirm_signal.setType(1);//设置读取哪个文件
        three_confirm_signal.read();
        three_confirm_signal.Restore();
        range = three_confirm_signal.China_Mobile_power.size();
        /**
         * 设置button的点击事件
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 得到用户输入信息  频率 和 时间
                 */
                if (!editTextfre.getText().toString().equals("")){
                    fre = editTextfre.getText().toString();
                }

                new Thread(){
                    public void run(){
                        /**
                         * 根据数据长度循环
                         */
                        int index=range-1;
                        while (true){
                            try {
                                if (editTextfre.getText().toString().equals("")){
                                    sleep(1);
                                }else if (Integer.parseInt(fre)!=0){
                                    sleep(1000/Integer.parseInt(fre));
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (view.data.size()>350){
                                view.data.remove(0);
                            }
                            if (range--<=0){
                                break;
                            }
                            Float data = three_confirm_signal.China_Mobile_power.get(index--);
                            view.data.add(data);
                        }
//                        range = three_confirm_signal.China_Mobile_power.size();
//                        index = range-1;
                    }
                }.start();
            }
        });
        button_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondSignalActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
