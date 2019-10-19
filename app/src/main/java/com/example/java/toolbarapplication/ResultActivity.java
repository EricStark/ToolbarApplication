package com.example.java.toolbarapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public Match_Result match_result = Match_Result.getinstance_match();
    public TextView textView;
    public TextView textView2;
    public TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = findViewById(R.id.tv_sin1);
        textView.setText(match_result.list_type.get(0));
        textView2 = findViewById(R.id.tv_sin2);
        textView2.setText(match_result.list_type.get(1));
        textView3 = findViewById(R.id.tv_sin3);
        textView3.setText(match_result.list_type.get(2));
    }
}
