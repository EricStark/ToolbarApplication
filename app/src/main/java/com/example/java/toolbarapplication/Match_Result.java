package com.example.java.toolbarapplication;

import java.util.ArrayList;
import java.util.List;

public class Match_Result {

    List<Float> list1_1 = new ArrayList<>();
    List<Float> list1_2 = new ArrayList<>();
    List<Float> list1_3 = new ArrayList<>();
    List<Float> list2_1 = new ArrayList<>();
    List<Float> list2_2 = new ArrayList<>();
    List<Float> list2_3 = new ArrayList<>();
    List<Float> list3_1 = new ArrayList<>();
    List<Float> list3_2 = new ArrayList<>();
    List<Float> list3_3 = new ArrayList<>();
    List<Float> list4_1 = new ArrayList<>();
    List<Float> list4_2 = new ArrayList<>();
    List<Float> list4_3 = new ArrayList<>();
    List<Float> list5_1 = new ArrayList<>();
    List<Float> list5_2 = new ArrayList<>();
    List<Float> list5_3 = new ArrayList<>();
    List<Float> list6_1 = new ArrayList<>();
    List<Float> list6_2 = new ArrayList<>();
    List<Float> list6_3 = new ArrayList<>();
    List<Float> list7_1 = new ArrayList<>();
    List<Float> list7_2 = new ArrayList<>();
    List<Float> list7_3 = new ArrayList<>();
    List<Float> list8_1 = new ArrayList<>();
    List<Float> list8_2 = new ArrayList<>();
    List<Float> list8_3 = new ArrayList<>();
    List<Float> list9_1 = new ArrayList<>();
    List<Float> list9_2 = new ArrayList<>();
    List<Float> list9_3 = new ArrayList<>();
    List<Float> list10_1 = new ArrayList<>();
    List<Float> list10_2 = new ArrayList<>();
    List<Float> list10_3 = new ArrayList<>();
    List<Float> list11_1 = new ArrayList<>();
    List<Float> list11_2 = new ArrayList<>();
    List<Float> list11_3 = new ArrayList<>();
    List<Float> list12_1 = new ArrayList<>();
    List<Float> list12_2 = new ArrayList<>();
    List<Float> list12_3 = new ArrayList<>();
    List<String> list_type = new ArrayList<>();

    private static Match_Result match_result = new Match_Result();

    private  Match_Result(){}

    public static Match_Result getinstance_match(){
        return match_result;
    }
}
