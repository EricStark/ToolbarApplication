package com.example.java.toolbarapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Slide {
    public readData readData;
    public Three_confirm_Signal mthree_confirm_signal;
    public int K,N;
    public int innerCycle;
    float new_shi = 0;
    float new_xu = 0;
    //联通滑动z[]数组
    List <Float>list1_Zshi = new ArrayList();
    List <Float>list1_Zxu = new ArrayList();
    List<Float> list_p1 = new ArrayList<>();
    //
    List<Float> list2_Zshi = new ArrayList();
    List<Float> list2_Zxu = new ArrayList();
    List<Float> list_p2 = new ArrayList<>();
    //
    List<Float> list3_Zshi = new ArrayList();
    List<Float> list3_Zxu = new ArrayList();
    List<Float> list_p3 = new ArrayList<>();

    List<Float> list_compare = new ArrayList<>();
    public Slide(readData readData, Three_confirm_Signal three_confirm_signal){
        this.readData = readData;
        this.mthree_confirm_signal = three_confirm_signal;
    }

    public void Slide_Caculate(){
                N = readData.list_shi.size()/2;//实际信号长度
                System.out.println("实际信号长度"+N);
                K = N-mthree_confirm_signal.China_Unicom_shi.size();//外循环长度
                System.out.println("外循环长度"+K);
                innerCycle = mthree_confirm_signal.China_Unicom_shi.size();//内循环长度
                System.out.println("内循环长度"+innerCycle);
                //联通滑动计算
                for (int i=0;i<K;i++){
                    for (int j=0;j<innerCycle;j++){
                        float union_shi = Float.parseFloat((String) mthree_confirm_signal.China_Unicom_shi.get(j));
                        float true_shi = Float.parseFloat((String) readData.list_shi.get(j+i));
                        float union_xu = Float.parseFloat((String) mthree_confirm_signal.China_Unicom_xu.get(j));
                        float true_xu = Float.parseFloat((String) readData.list_xu.get(j+i));
                        new_shi = new_shi+(union_shi*true_shi-union_xu*true_xu);
                        new_xu = new_xu+(union_shi*true_xu+union_xu*true_shi);
                    }
                    list1_Zshi.add(new_shi);//匹配后信号点集
                    list1_Zxu.add(new_xu);
                }
                for (int m=0;m<list1_Zshi.size();m++){
                    float data = (float) Math.sqrt(list1_Zshi.get(m)*list1_Zshi.get(m)+list1_Zxu.get(m)*list1_Zxu.get(m));
                    list_p1.add(data);

                }
                //移动滑动计算
                for (int i=0;i<K;i++){
                    for (int j=0;j<innerCycle;j++){
                        float mobile_shi = Float.parseFloat((String) mthree_confirm_signal.China_Mobile_shi.get(j));
                        float true_shi = Float.parseFloat((String) readData.list_shi.get(j+i));
                        float mobile_xu = Float.parseFloat((String) mthree_confirm_signal.China_Mobile_xu.get(j)) ;
                        float true_xu = Float.parseFloat((String) readData.list_xu.get(j+i));
                        new_shi = new_shi+mobile_shi*true_shi-mobile_xu*true_xu;
                        new_xu = new_xu+mobile_shi*true_xu+mobile_xu*true_shi;
                    }
                    list2_Zshi.add(new_shi);
                    list2_Zxu.add(new_xu);
                }
                for (int m=0;m<list2_Zshi.size();m++){
                    float data = (float) Math.sqrt(list2_Zshi.get(m)*list2_Zshi.get(m)+list2_Zxu.get(m)*list2_Zxu.get(m));
                    list_p2.add(data);
                }
                //电信滑动计算
                for (int i=0;i<K;i++){
                    for (int j=0;j<innerCycle;j++){
                        float telecom_shi = Float.parseFloat((String) mthree_confirm_signal.China_Telecom_shi.get(j));
                        float true_shi = Float.parseFloat((String) readData.list_shi.get(j+i));
                        float telecam_xu = Float.parseFloat((String) mthree_confirm_signal.China_Telecom_xu.get(j));
                        float true_xu = Float.parseFloat((String) readData.list_xu.get(j+i));
                        new_shi = new_shi+telecom_shi*true_shi-telecam_xu*true_xu;
                        new_xu = new_xu+telecom_shi*true_xu+telecam_xu*true_shi;
                    }
                    list3_Zshi.add(new_shi);
                    list3_Zxu.add(new_xu);
                }
                for (int m=0;m<list3_Zshi.size();m++){
                    float data = (float) Math.sqrt(list3_Zshi.get(m)*list3_Zshi.get(m)+list3_Zxu.get(m)*list3_Zxu.get(m));
                    list_p3.add(data);
                }
                float data1 = Collections.max(list_p1);
                float data2 = Collections.max(list_p2);
                float data3 = Collections.max(list_p3);
                list_compare.add(data1);
                list_compare.add(data2);
                list_compare.add(data3);
    }

}
