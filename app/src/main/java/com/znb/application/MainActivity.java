package com.znb.application;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.znb.myapplication.ICalcAIDL;

public class MainActivity extends AppCompatActivity {
    private ICalcAIDL mCalcAidl;

    private ServiceConnection mServiceConn = new ServiceConnection()
    {
        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            Log.e("client", "onServiceDisconnected");
            mCalcAidl = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            Log.e("client", "onServiceConnected");
            mCalcAidl = ICalcAIDL.Stub.asInterface(service);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * 点击BindService按钮时调用
     * @param view
     */
    public void bindService(View view)
    {
        Intent intent = new Intent(this,CalcService.class);
//        intent.setAction("com.zhy.aidl.calc");
        bindService(intent, mServiceConn, Context.BIND_AUTO_CREATE);
    }
    /**
     * 点击unBindService按钮时调用
     * @param view
     */
    public void unbindService(View view)
    {
        unbindService(mServiceConn);
    }
    /**
     * 点击12+12按钮时调用
     * @param view
     */
    public void addInvoked(View view) throws Exception
    {

        if (mCalcAidl != null)
        {
            int addRes = mCalcAidl.add(12, 12);
            Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT)
                    .show();

        }

    }
    /**
     * 点击50-12按钮时调用
     * @param view
     */
    public void minInvoked(View view) throws Exception
    {

        if (mCalcAidl != null)
        {
            int addRes = mCalcAidl.min(58, 12);
            Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "服务端未绑定或被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT)
                    .show();

        }

    }
}
