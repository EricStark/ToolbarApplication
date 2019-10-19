package com.example.java.toolbarapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * 用于后台计算的服务
 */
public class CaculateService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    /**
     * 服务中的计算方法
     */
    public void CaculateInService(readData readData){
        readData.Caculate(readData.list_shi,readData.list_xu);
    }
    /**
     * 定义一个中间人对象
     */
    class MyBinder extends Binder{

        //调用服务里的方法
        public void CallCaculateInService(readData readData){
            CaculateInService(readData);
        }
    }

}

