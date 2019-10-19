package com.example.java.toolbarapplication;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类用于读取文件数据
 */
public class readData {
    //创建12个实列对象
    private static readData instanceReadata1 = new readData();
    private static readData instanceReadata2 = new readData();
    private static readData instanceReadata3 = new readData();
    private static readData instanceReadata4 = new readData();
    private static readData instanceReadata5 = new readData();
    private static readData instanceReadata6 = new readData();
    private static readData instanceReadata7 = new readData();
    private static readData instanceReadata8 = new readData();
    private static readData instanceReadata9 = new readData();
    private static readData instanceReadata10 = new readData();
    private static readData instanceReadata11 = new readData();
    private static readData instanceReadata12 = new readData();


    //创建接收容器，接收实部和虚部
    public List list_shi = new ArrayList() ;
    public List list_xu = new ArrayList();
    public List listdata = new ArrayList();
    public List<Float> list_power = new ArrayList<>();
    public Context context;
    public InputStream is;
    public String path;
    /**
     * 读取数据
     * @param
     */
    public static readData getInstanceReadata1(Context context,String path){
        instanceReadata1.context = context;
        instanceReadata1.path = path;
        return instanceReadata1;
    }
    public static readData getInstanceReadata2(Context context,String path){
        instanceReadata2.context = context;
        instanceReadata2.path = path;
        return instanceReadata2;
    }
    public static readData getInstanceReadata3(Context context,String path){
        instanceReadata3.context = context;
        instanceReadata3.path = path;
        return instanceReadata3;
    }
    public static readData getInstanceReadata4(Context context,String path){
        instanceReadata4.context = context;
        instanceReadata4.path = path;
        return instanceReadata4;
    }
    public static readData getInstanceReadata5(Context context,String path){
        instanceReadata5.context = context;
        instanceReadata5.path = path;
        return instanceReadata5;
    }
    public static readData getInstanceReadata6(Context context,String path){
        instanceReadata6.context = context;
        instanceReadata6.path = path;
        return instanceReadata6;
    }
    public static readData getInstanceReadata7(Context context,String path){
        instanceReadata7.context = context;
        instanceReadata7.path = path;
        return instanceReadata7;
    }
    public static readData getInstanceReadata8(Context context,String path){
        instanceReadata8.context = context;
        instanceReadata8.path = path;
        return instanceReadata8;
    }
    public static readData getInstanceReadata9(Context context,String path){
        instanceReadata9.context = context;
        instanceReadata9.path = path;
        return instanceReadata9;
    }
    public static readData getInstanceReadata10(Context context,String path){
        instanceReadata10.context = context;
        instanceReadata10.path = path;
        return instanceReadata10;
    }
    public static readData getInstanceReadata11(Context context,String path){
        instanceReadata11.context = context;
        instanceReadata11.path = path;
        return instanceReadata11;
    }
    public static readData getInstanceReadata12(Context context,String path){
        instanceReadata12.context = context;
        instanceReadata12.path = path;
        return instanceReadata12;
    }
    private readData(){

    }
    public void readfileData(){

            String temp = null;
            try {
                is = context.getResources().getAssets().open(path);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                while ((temp=bufferedReader.readLine())!=null){
                    listdata.add(temp);
                }
                for (int j=0;j<listdata.size();j++){
                    //存储数据
                    if (j%2==0){
                        list_shi.add(listdata.get(j));
                    }else {
                        list_xu.add(listdata.get(j));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    /**
     * 进行功率计算
     * @param list_shi
     * @param list_xu
     */
    public float Caculate(List list_shi,List list_xu){
        float finalpower=0;

        for (int i=0;i<list_shi.size();i++){
            float shibu = Float.parseFloat((String) list_shi.get(i));
            float xubu = Float.parseFloat((String)list_xu.get(i));
            float power = (float) Math.sqrt(shibu*shibu+xubu*xubu);
            list_power.add(power);//这个是每个实际信号的强度数集
            finalpower = finalpower+(float) Math.sqrt(shibu*shibu+xubu*xubu);
        }
        return finalpower;//信号功率
    }

}
