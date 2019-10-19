package com.example.java.toolbarapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyLinearAdapter extends RecyclerView.Adapter<MyLinearAdapter.LinearViewHolder> {

    public Context mContext;
    public List<Float> mList;

    public MyLinearAdapter(Context context,List<Float> list){
        this.mContext = context;
        this.mList = list;
    }
    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.analyse_linearitemview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder viewHolder, final int position) {
        viewHolder.progressBar.setMax(Math.round(Collections.max(mList)));//对progress设置最大值
        viewHolder.textView1.setText("signa-"+position);
        viewHolder.progressBar.setProgress(Math.round(mList.get(position)));
        //item点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent0  = new Intent(mContext,Signal1Activity.class);
                        mContext.startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(mContext,Signal2Activity.class);
                        mContext.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(mContext,Signal3Activity.class);
                        mContext.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(mContext,Signal4Activity.class);
                        mContext.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(mContext,Signal5Activity.class);
                        mContext.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(mContext,Signal6Activity.class);
                        mContext.startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(mContext,Signal7Activity.class);
                        mContext.startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(mContext,Signal8Activity.class);
                        mContext.startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(mContext,Signal9Activity.class);
                        mContext.startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(mContext,Signal10Activity.class);
                        mContext.startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(mContext,Signal11Activity.class);
                        mContext.startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11 = new Intent(mContext,Signal12Activity.class);
                        mContext.startActivity(intent11);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 12;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView circleImageView;
        public TextView textView1,textView2;
        public ProgressBar progressBar;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.xinhao);
            textView1 = itemView.findViewById(R.id.tv);
            textView2 = itemView.findViewById(R.id.tv2);
            progressBar = itemView.findViewById(R.id.progress);
        }
    }

}
