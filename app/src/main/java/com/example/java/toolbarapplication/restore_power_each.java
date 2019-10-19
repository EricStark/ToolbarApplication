package com.example.java.toolbarapplication;

import java.util.ArrayList;
import java.util.List;

public class restore_power_each {

    public List<Float> list_sin1 = new ArrayList<>();
    public List<Float> list_sin2 = new ArrayList<>();
    public List<Float> list_sin3 = new ArrayList<>();
    public List<Float> list_sin4 = new ArrayList<>();
    public List<Float> list_sin5 = new ArrayList<>();
    public List<Float> list_sin6 = new ArrayList<>();
    public List<Float> list_sin7 = new ArrayList<>();
    public List<Float> list_sin8 = new ArrayList<>();
    public List<Float> list_sin9 = new ArrayList<>();
    public List<Float> list_sin10 = new ArrayList<>();
    public List<Float> list_sin11 = new ArrayList<>();
    public List<Float> list_sin12 = new ArrayList<>();

    /**
     * 单例模式
     */
    public static restore_power_each instance = new restore_power_each();
    public restore_power_each(){}
    public static restore_power_each getinstance(){
        return instance;
    }

}
