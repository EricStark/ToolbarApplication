package com.example.java.toolbarapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CaculateService.MyBinder myBinder;//中间人对象
    private Welcome_SimpleChartView view;
    public Match_Result Tphone = Match_Result.getinstance_match(); //手机类型
    private Myconn myconn;
    private TextView textView_title;
    private TextView textView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Button buttonSubmit;    //提交按钮
    public String phone_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startDraw();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView_title = findViewById(R.id.tv_title);
        buttonSubmit = findViewById(R.id.btn_submit);//找到提交按钮
        textView = findViewById(R.id.tv_phone);
        textView.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);//设置提交按钮的点击事件

        Intent intent = new Intent(MainActivity.this,CaculateService.class);
        myconn = new Myconn();
        bindService(intent,myconn,BIND_AUTO_CREATE);//绑定服务

        AssetManager assetManager = getAssets();                                                     //得到assetManager
        Typeface typeface = Typeface.createFromAsset(assetManager,"fonts/feizhai.ttf");        //设置typeface并传入assetManager
        textView_title.setTypeface(typeface);                                                        //设置textview的字体
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);
        navigationView.setCheckedItem(R.id.signal1);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.signal1:
                        Intent intent1 = new Intent(MainActivity.this,FirstSignalActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.signal2:
                        Intent intent2 = new Intent(MainActivity.this,SecondSignalActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.signal3:
                        Intent intent3 = new Intent(MainActivity.this,ThirdSignalActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.result:
                        Intent intent4 = new Intent(MainActivity.this,ResultActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.analyse:
                        Intent intent5 = new Intent(MainActivity.this,Analyse_ResultActivity.class);
                        startActivity(intent5);
                        break;
                }
                return true;
            }
        });
        View Headerview = navigationView.getHeaderView(0);                              //通过navigationView找到headerview
        Headerview.findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {  //通过headerview找到对应控件，再设置监听事件
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }

    /**
     * 点击事件的监听器
     * @param
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_phone:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("注意").setCancelable(false).setMessage("请选择手机类型").setPositiveButton("中国联通", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("中国联通");
                    }
                }).setNegativeButton("中国移动", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("中国移动");
                    }
                }).setNeutralButton("中国电信", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("中国电信");
                    }
                });
                dialog.show();
                break;
            case R.id.btn_submit:
                if (textView.getText().toString().equals("")){
                    Toast.makeText(this,"请设置手机类型",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
                phone_type = ((String) textView.getText()).trim();
                Tphone.list_type.add(phone_type);//加入手机类型
                break;
        }
    }

    /**
     * 绑定服务与解绑服务的回调方法
     * @param service
     * @param conn
     * @param flags
     * @return
     */
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return super.bindService(service, conn, flags);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }
    public class Myconn implements ServiceConnection{

        /**
         * 当Activity与服务绑定的时候调用
         * @param name
         * @param service
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (CaculateService.MyBinder) service;
        }

        /**
         * 当Activity与服务取消绑定的时候调用
         * @param name
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    /**
     * 活动销毁时解绑服务
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(myconn);
    }

    /**
     * 开始画画
     */
    public void startDraw(){
        new Thread(){
            public void run(){
                /**
                 * 根据数据长度循环
                 */
                while (true){
                    try {
                        sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (view.data.size()>150){
                        view.data.remove(0);
                    }
                    view.data.add(new Random().nextInt(10));
                }
            }
        }.start();
    }
}
