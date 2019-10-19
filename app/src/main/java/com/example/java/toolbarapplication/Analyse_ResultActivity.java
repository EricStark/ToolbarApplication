package com.example.java.toolbarapplication;
import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyse_ResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public List list_each_power = new ArrayList();//装每个信号强度的容器
    public List before_list = new ArrayList();
    public List<Integer> index_order = new ArrayList<>();
    public restore_power_each each = restore_power_each.getinstance();
    public Match_Result match_result = Match_Result.getinstance_match();
    final Three_confirm_Signal three_confirm_signal = Three_confirm_Signal.getInstance();
    public Slide slide ;
    public int TYPE;
    public boolean flag = false;
    String[] path = {"data40.txt","data41.txt",
            "data42.txt","data43.txt","data44.txt",
            "data45.txt","data46.txt","data47.txt",
            "data48.txt","data49.txt","data50.txt","data51.txt"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(Analyse_ResultActivity.this);
        progressDialog.setTitle("注意：");
        progressDialog.setMessage("正在数据匹配计算中...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse__result);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in1 = readData.getInstanceReadata1(Analyse_ResultActivity.this,path[0]);
                in1.readfileData();
                float each_power0 = in1.Caculate(in1.list_shi,in1.list_xu);
                list_each_power.add(each_power0);
                //为每个信号添加数据集合
                for (int a1=0;a1<in1.list_power.size();a1++){
                    each.list_sin1.add(in1.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in2 = readData.getInstanceReadata2(Analyse_ResultActivity.this,path[1]);
                in2.readfileData();
                float each_power1 = in2.Caculate(in2.list_shi,in2.list_xu);
                list_each_power.add(each_power1);
                //为每个信号添加数据集合
                for (int a1=0;a1<in2.list_power.size();a1++){
                    each.list_sin2.add(in2.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in3 = readData.getInstanceReadata3(Analyse_ResultActivity.this,path[2]);
                in3.readfileData();
                float each_power2 = in3.Caculate(in3.list_shi,in3.list_xu);
                list_each_power.add(each_power2);
                //为每个信号添加数据集合
                for (int a1=0;a1<in3.list_power.size();a1++){
                    each.list_sin3.add(in3.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in4 = readData.getInstanceReadata4(Analyse_ResultActivity.this,path[3]);
                in4.readfileData();
                float each_power3 = in4.Caculate(in4.list_shi,in4.list_xu);
                list_each_power.add(each_power3);
                //为每个信号添加数据集合
                for (int a1=0;a1<in4.list_power.size();a1++){
                    each.list_sin4.add(in4.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in5 = readData.getInstanceReadata5(Analyse_ResultActivity.this,path[4]);
                in5.readfileData();
                float each_power4 = in5.Caculate(in5.list_shi,in5.list_xu);
                list_each_power.add(each_power4);
                //为每个信号添加数据集合
                for (int a1=0;a1<in5.list_power.size();a1++){
                    each.list_sin5.add(in5.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in6 = readData.getInstanceReadata6(Analyse_ResultActivity.this,path[5]);
                in6.readfileData();
                float each_power5 = in6.Caculate(in6.list_shi,in6.list_xu);
                list_each_power.add(each_power5);
                //为每个信号添加数据集合
                for (int a1=0;a1<in6.list_power.size();a1++){
                    each.list_sin6.add(in6.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in7 = readData.getInstanceReadata7(Analyse_ResultActivity.this,path[6]);
                in7.readfileData();
                float each_power6 = in7.Caculate(in7.list_shi,in7.list_xu);
                list_each_power.add(each_power6);
                //为每个信号添加数据集合
                for (int a1=0;a1<in7.list_power.size();a1++){
                    each.list_sin7.add(in7.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in8 = readData.getInstanceReadata8(Analyse_ResultActivity.this,path[7]);
                in8.readfileData();
                float each_power7 = in8.Caculate(in8.list_shi,in8.list_xu);
                list_each_power.add(each_power7);
                //为每个信号添加数据集合
                for (int a1=0;a1<in8.list_power.size();a1++){
                    each.list_sin8.add(in8.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in9 = readData.getInstanceReadata9(Analyse_ResultActivity.this,path[8]);
                in9.readfileData();
                float each_power8 = in9.Caculate(in9.list_shi,in9.list_xu);
                list_each_power.add(each_power8);
                //为每个信号添加数据集合
                for (int a1=0;a1<in9.list_power.size();a1++){
                    each.list_sin9.add(in9.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in10 = readData.getInstanceReadata10(Analyse_ResultActivity.this,path[9]);
                in10.readfileData();
                float each_power9 = in10.Caculate(in10.list_shi,in10.list_xu);
                list_each_power.add(each_power9);
                //为每个信号添加数据集合
                for (int a1=0;a1<in10.list_power.size();a1++){
                    each.list_sin10.add(in10.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in11 = readData.getInstanceReadata11(Analyse_ResultActivity.this,path[10]);
                in11.readfileData();
                float each_power10 = in11.Caculate(in11.list_shi,in11.list_xu);
                list_each_power.add(each_power10);
                //为每个信号添加数据集合
                for (int a1=0;a1<in11.list_power.size();a1++){
                    each.list_sin11.add(in11.list_power.get(a1));
                }

                //每次调用readData方法都会创建新的装实部和虚部的容器，所有要分清楚是那个readDtata对象的容器
                readData in12 = readData.getInstanceReadata12(Analyse_ResultActivity.this,path[11]);
                in12.readfileData();
                float each_power11 = in12.Caculate(in12.list_shi,in12.list_xu);
                list_each_power.add(each_power11);
                //为每个信号添加数据集合
                for (int a1=0;a1<in12.list_power.size();a1++){
                    each.list_sin12.add(in12.list_power.get(a1));
                }
                Sort();
                Mapping();
                //转化手机类型为对应整数
                if (match_result.list_type.get(0).equals("中国联通")){
                    TYPE = 0;
                }
                if (match_result.list_type.get(0).equals("中国移动")){
                    TYPE = 1;
                }
                if (match_result.list_type.get(0).equals("中国电信")){
                    TYPE = 2;
                }
                for (int i=1;i<=index_order.size();i++){
                    if (flag){
                        break;
                    }
                    int index = index_order.get(index_order.size()-i);//从大到小一次得到信号文件编号
                    switch (index){
                        case 0:
                            slide = new Slide(in1,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list1_1.add(slide.list_compare.get(0));//第一个信号与联通匹配强度
                            match_result.list1_2.add(slide.list_compare.get(1));//第一个信号与移动匹配强度
                            match_result.list1_3.add(slide.list_compare.get(2));//第一个信号与移动匹配强度
                            float m = Collections.max(slide.list_p1);
                            float n = Collections.max(slide.list_p2);
                            float e = Collections.max(slide.list_p3);
                            List<Float> list = new ArrayList();
                            list.add(m);
                            list.add(n);
                            list.add(e);
                            int t = list.indexOf(Collections.max(list));//0-->联通  1-->移动  2-->电信
                            if (t==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号一");
                                match_result.list_type.add(Collections.max(list).toString());
                            }
                            //判断
                            break;
                        case 1:
                            slide = new Slide(in2,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list2_1.add(slide.list_compare.get(0));
                            match_result.list2_2.add(slide.list_compare.get(1));
                            match_result.list2_3.add(slide.list_compare.get(2));
                            float m1 = Collections.max(slide.list_p1);
                            float n1 = Collections.max(slide.list_p2);
                            float e1 = Collections.max(slide.list_p3);
                            List<Float> list1 = new ArrayList();
                            list1.add(m1);
                            list1.add(n1);
                            list1.add(e1);
                            System.out.println("三个运营商的最大信号分别是："+m1+n1+e1);
                            int t1 = list1.indexOf(Collections.max(list1));//0-->联通  1-->移动  2-->电信
                            if (t1==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号二");
                                match_result.list_type.add(Collections.max(list1).toString());
                            }
                            break;
                        case 2:
                            slide = new Slide(in3,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list3_1.add(slide.list_compare.get(0));
                            match_result.list3_2.add(slide.list_compare.get(1));
                            match_result.list3_3.add(slide.list_compare.get(2));
                            float m2 = Collections.max(slide.list_p1);
                            float n2 = Collections.max(slide.list_p2);
                            float e2 = Collections.max(slide.list_p3);
                            List<Float> list2 = new ArrayList();
                            list2.add(m2);
                            list2.add(n2);
                            list2.add(e2);
                            int t2 = list2.indexOf(Collections.max(list2));//0-->联通  1-->移动  2-->电信
                            if (t2==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号三");
                                match_result.list_type.add(Collections.max(list2).toString());
                            }
                            break;
                        case 3:
                            slide = new Slide(in4,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list4_1.add(slide.list_compare.get(0));
                            match_result.list4_2.add(slide.list_compare.get(1));
                            match_result.list4_3.add(slide.list_compare.get(2));
                            float m3 = Collections.max(slide.list_p1);
                            float n3 = Collections.max(slide.list_p2);
                            float e3 = Collections.max(slide.list_p3);
                            List<Float> list3 = new ArrayList();
                            list3.add(m3);
                            list3.add(n3);
                            list3.add(e3);
                            int t3 = list3.indexOf(Collections.max(list3));//0-->联通  1-->移动  2-->电信
                            if (t3==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号四");
                                match_result.list_type.add(Collections.max(list3).toString());
                            }
                            break;
                        case 4:
                            slide = new Slide(in5,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list5_1.add(slide.list_compare.get(0));
                            match_result.list5_2.add(slide.list_compare.get(1));
                            match_result.list5_3.add(slide.list_compare.get(2));
                            float m4 = Collections.max(slide.list_p1);
                            float n4 = Collections.max(slide.list_p2);
                            float e4 = Collections.max(slide.list_p3);
                            List<Float> list4 = new ArrayList();
                            list4.add(m4);
                            list4.add(n4);
                            list4.add(e4);
                            int t4 = list4.indexOf(Collections.max(list4));//0-->联通  1-->移动  2-->电信
                            if (t4==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号五");
                                match_result.list_type.add(Collections.max(list4).toString());
                            }
                            break;
                        case 5:
                            slide = new Slide(in6,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list6_1.add(slide.list_compare.get(0));
                            match_result.list6_2.add(slide.list_compare.get(1));
                            match_result.list6_3.add(slide.list_compare.get(2));
                            float m5 = Collections.max(slide.list_p1);
                            float n5= Collections.max(slide.list_p2);
                            float e5 = Collections.max(slide.list_p3);
                            List<Float> list5 = new ArrayList();
                            list5.add(m5);
                            list5.add(n5);
                            list5.add(e5);
                            int t5 = list5.indexOf(Collections.max(list5));//0-->联通  1-->移动  2-->电信
                            if (t5==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号六");
                                match_result.list_type.add(Collections.max(list5).toString());
                            }
                            break;
                        case 6:
                            slide = new Slide(in7,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list7_1.add(slide.list_compare.get(0));
                            match_result.list7_2.add(slide.list_compare.get(1));
                            match_result.list7_3.add(slide.list_compare.get(2));
                            float m7 = Collections.max(slide.list_p1);
                            float n7 = Collections.max(slide.list_p2);
                            float e7 = Collections.max(slide.list_p3);
                            List<Float> list7 = new ArrayList();
                            list7.add(m7);
                            list7.add(n7);
                            list7.add(e7);
                            int t7 = list7.indexOf(Collections.max(list7));//0-->联通  1-->移动  2-->电信
                            if (t7==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号七");
                                match_result.list_type.add(Collections.max(list7).toString());
                            }
                            break;
                        case 7:
                            slide = new Slide(in8,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list8_1.add(slide.list_compare.get(0));
                            match_result.list8_2.add(slide.list_compare.get(1));
                            match_result.list8_3.add(slide.list_compare.get(2));
                            float m8 = Collections.max(slide.list_p1);
                            float n8 = Collections.max(slide.list_p2);
                            float e8 = Collections.max(slide.list_p3);
                            List<Float> list8 = new ArrayList();
                            list8.add(m8);
                            list8.add(n8);
                            list8.add(e8);
                            int t8 = list8.indexOf(Collections.max(list8));//0-->联通  1-->移动  2-->电信
                            if (t8==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号八");
                                match_result.list_type.add(Collections.max(list8).toString());
                            }
                            break;
                        case 8:
                            slide = new Slide(in9,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list9_1.add(slide.list_compare.get(0));
                            match_result.list9_2.add(slide.list_compare.get(1));
                            match_result.list9_3.add(slide.list_compare.get(2));
                            float m9 = Collections.max(slide.list_p1);
                            float n9 = Collections.max(slide.list_p2);
                            float e9 = Collections.max(slide.list_p3);
                            List<Float> list9 = new ArrayList();
                            list9.add(m9);
                            list9.add(n9);
                            list9.add(e9);
                            int t9 = list9.indexOf(Collections.max(list9));//0-->联通  1-->移动  2-->电信
                            if (t9==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号九");
                                match_result.list_type.add(Collections.max(list9).toString());
                            }
                            break;
                        case 9:
                            slide = new Slide(in10,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list10_1.add(slide.list_compare.get(0));
                            match_result.list10_2.add(slide.list_compare.get(1));
                            match_result.list10_3.add(slide.list_compare.get(2));
                            float m10 = Collections.max(slide.list_p1);
                            float n10 = Collections.max(slide.list_p2);
                            float e10 = Collections.max(slide.list_p3);
                            List<Float> list10 = new ArrayList();
                            list10.add(m10);
                            list10.add(n10);
                            list10.add(e10);
                            int t10 = list10.indexOf(Collections.max(list10));//0-->联通  1-->移动  2-->电信
                            if (t10==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号十");
                                match_result.list_type.add(Collections.max(list10).toString());
                            }
                            break;
                        case 10:
                            slide = new Slide(in11,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list11_1.add(slide.list_compare.get(0));
                            match_result.list11_2.add(slide.list_compare.get(1));
                            match_result.list11_3.add(slide.list_compare.get(2));
                            float m11 = Collections.max(slide.list_p1);
                            float n11 = Collections.max(slide.list_p2);
                            float e11 = Collections.max(slide.list_p3);
                            List<Float> list11 = new ArrayList();
                            list11.add(m11);
                            list11.add(n11);
                            list11.add(e11);
                            int t11 = list11.indexOf(Collections.max(list11));//0-->联通  1-->移动  2-->电信
                            if (t11==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号十一");
                                match_result.list_type.add(Collections.max(list11).toString());
                            }
                            break;
                        case 11:
                            slide = new Slide(in12,three_confirm_signal);
                            slide.Slide_Caculate();
                            match_result.list12_1.add(slide.list_compare.get(0));
                            match_result.list12_2.add(slide.list_compare.get(1));
                            match_result.list12_3.add(slide.list_compare.get(2));
                            float m12 = Collections.max(slide.list_p1);
                            float n12 = Collections.max(slide.list_p2);
                            float e12 = Collections.max(slide.list_p3);
                            List<Float> list12 = new ArrayList();
                            list12.add(m12);
                            list12.add(n12);
                            list12.add(e12);
                            int t12 = list12.indexOf(Collections.max(list12));//0-->联通  1-->移动  2-->电信
                            if (t12==TYPE){
                                flag = true;
                                match_result.list_type.add("基站信号十二");
                                match_result.list_type.add(Collections.max(list12).toString());
                            }
                            break;
                    }

                }
                //排序
                //Sort();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView = findViewById(R.id.rl_analyse);
                        recyclerView.setLayoutManager(new LinearLayoutManager(Analyse_ResultActivity.this));
                        recyclerView.setAdapter(new MyLinearAdapter(Analyse_ResultActivity.this,before_list));
                        progressDialog.dismiss();
                    }
                });

            }
        }).start();
    }
    public void Sort(){
        for (int i=0;i<list_each_power.size();i++){
            before_list.add(list_each_power.get(i));
        }
        Collections.sort(list_each_power);
    }
    public void Mapping(){
        for (int i=0;i<list_each_power.size();i++){
            for (int j=0;j<list_each_power.size();j++){
                if (list_each_power.get(i).equals(before_list.get(j))){
                    index_order.add(j);//存储从小到大信号文件索引
                }
            }

        }
    }
}
