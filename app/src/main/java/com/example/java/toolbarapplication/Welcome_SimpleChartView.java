package com.example.java.toolbarapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Welcome_SimpleChartView extends View {
    private int winY;//手机y分辨率
    int xtart,ystart;
    private Paint paint1,paint2;
    public static List<Integer> data = new ArrayList<>();
    private  Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //开启子线程指定一个定时任务
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mHandler.sendMessage(mHandler.obtainMessage());
                    Welcome_SimpleChartView.this.invalidate();//利用自定义view对象调用重绘方法
                }
            },100);
        }
    };
    public Welcome_SimpleChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHandler.sendMessage(mHandler.obtainMessage());//执行构造方法时发送一个空消息
        getWindowScale(context);//通过上下文获得手机窗口宽度
        paint1 = new Paint(); //创建画笔
        paint2 = new Paint();
        paint1.setStrokeWidth(6);
        paint1.setTextSize(50);
        paint2.setStrokeWidth(5);
    }
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        /**
         * 画信号图
         */
        xtart = 70;
        ystart = winY/4;

        DrawAxis(xtart,ystart,canvas);

    }

    /**
     * 得到手机窗口的大小，方便绘制图像
     */
    public void getWindowScale(Context context){
        //得到窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        manager.getDefaultDisplay().getSize(point);
        winY = point.y;
    }

    /**
     * 传入数据画出信号图
     */
    public void DrawAxis(int xstart,int ystart,Canvas canvas){

            //画笔设置
            paint1.setAntiAlias(true);
            paint2.setColor(Color.BLUE);
            if(data.size()>1) {
                for (int i = 0; i < data.size() - 1; i++) {
                    canvas.drawLine(xstart + i * 8, ystart-data.get(i) * 50, xstart + (i + 1) * 8, ystart- data.get(i + 1) * 50, paint2);
                }
            }
    }
}
