package com.example.java.toolbarapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Signal1Activity extends AppCompatActivity {

    public restore_power_each each = restore_power_each.getinstance();
    public SimpleChartView view;
    public int range;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal1);
        range = each.list_sin1.size()/3;
        /**
         * 得到用户输入信息  频率 和 时间
         */
        new Thread(){
            public void run(){
                /**
                 * 根据数据长度循环
                 */
                int index=range-1;
                while (true){
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (view.data.size()>350){
                        view.data.remove(0);
                    }
                    if (range--<=0){
                        break;
                    }
                    Float data = each.list_sin1.get(index--)/100;
                    view.data.add(data);
                }
                range=each.list_sin1.size();
                index = range-1;
            }
        }.start();
    }
}
