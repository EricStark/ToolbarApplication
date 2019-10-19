package com.example.java.toolbarapplication;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Three_confirm_Signal {
    public List China_Unicom_shi = new ArrayList();//中国联通
    public List China_Unicom_xu = new ArrayList();//中国联通
    public List China_Unicom = new ArrayList();
    public List<Float> China_Union_power = new ArrayList();
    public List China_Mobile_shi = new ArrayList();//中国移动
    public List China_Mobile_xu = new ArrayList();//中国移动
    public List China_Mobile = new ArrayList();
    public List<Float> China_Mobile_power = new ArrayList();
    public List China_Telecom_shi = new ArrayList();//中国电信
    public List China_Telecom_xu = new ArrayList();//中国电信
    public List China_Telecom = new ArrayList();
    public List<Float> China_Telecom_power = new ArrayList();

    public String path;
    public String path2;
    public String path3;
    public InputStream is;
    public Context context;
    public int type;

    public void setType(int type) {
        this.type = type;
    }
//    public Three_confirm_Signal(Context context,String path){
//        this.path = path;
//        this.context = context;
//    }
//    public Three_confirm_Signal(Context context,String path1,String path2,String path3){
//        this.context = context;
//        this.path = path1;
//        this.path2 = path2;
//        this.path3 = path3;
//    }

    /**
     * 单例模式
     */
    private Three_confirm_Signal(){
    }
    private static class SingleTonInstance{
        private static final Three_confirm_Signal instance = new Three_confirm_Signal();
    }
    public static Three_confirm_Signal getInstance(){
        return SingleTonInstance.instance;
    }
    public static Three_confirm_Signal getInstance(Context context,String path){
        Three_confirm_Signal instance = SingleTonInstance.instance;
        instance.path = path;
        instance.context = context;
        return instance;
    }

    public void read(){
        String temp;
        BufferedReader bufferedReader = null;
        try {
            is = context.getAssets().open(path);
            bufferedReader = new BufferedReader(new InputStreamReader(is));
            while ((temp=bufferedReader.readLine())!=null){
                switch (type){
                    case 0:
                        China_Unicom.add(temp);//添加中国联通数据
                        break;
                    case 1:
                        China_Mobile.add(temp);//添加中国移动数据
                        break;
                    case 2:
                        China_Telecom.add(temp);//添加中国电信数据
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Restore(){
        switch (type){
            case 0:
                //添加中国联通的实部和虚部数据
                for (int i=0;i<China_Unicom.size();i++){
                    if (i%2==0){
                        China_Unicom_shi.add(China_Unicom.get(i));
                    }else {
                        China_Unicom_xu.add(China_Unicom.get(i));
                    }
                }
                for (int i=0;i<China_Unicom_shi.size();i++){
                    float shi = Float.parseFloat((String) China_Unicom_shi.get(i));
                    float xu = Float.parseFloat((String) China_Unicom_xu.get(i));
                    float power = (float) Math.sqrt(shi*shi+xu*xu);
                    China_Union_power.add(power);
                }
                break;
            case 1:
                //添加中国移动的实部和虚部
                for (int i=0;i<China_Mobile.size();i++){
                    if (i%2==0){
                        China_Mobile_shi.add(China_Mobile.get(i));
                    }else {
                        China_Mobile_xu.add(China_Mobile.get(i));
                    }
                }
                for (int i=0;i<China_Mobile_shi.size();i++){
                    float shi = Float.parseFloat((String) China_Mobile_shi.get(i));
                    float xu = Float.parseFloat((String) China_Mobile_xu.get(i));
                    float power = (float) Math.sqrt(shi*shi+xu*xu);
                    China_Mobile_power.add(power);
                }
                break;
            case 2:
                //添加中国电信的实部和虚部
                for (int i=0;i<China_Telecom.size();i++){
                    if (i%2==0){
                        China_Telecom_shi.add(China_Telecom.get(i));
                    }else {
                        China_Telecom_xu.add(China_Telecom.get(i));
                    }
                }
                for (int i=0;i<China_Telecom_shi.size();i++){
                    float shi = Float.parseFloat((String) China_Telecom_shi.get(i));
                    float xu = Float.parseFloat((String) China_Telecom_xu.get(i));
                    float power = (float) Math.sqrt(shi*shi+xu*xu);
                    China_Telecom_power.add(power);
                }
                break;
        }

    }
}
