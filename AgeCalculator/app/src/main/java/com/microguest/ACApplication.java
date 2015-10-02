package com.microguest;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import org.androidannotations.annotations.EApplication;

import com.microguest.utils.ACLogger;
import com.microguest.utils.PropertiesConfig;

/**
 * Created by wuyajun on 15/10/2.
 */
@EApplication
public class ACApplication extends Application {

    public static ACLogger Logs = ACLogger.kLog();

    @Override
    public void onCreate() {
        super.onCreate();

        //(严格模式):监视APP相关的运行情况 - 发布应用时关闭此处
        if (!PropertiesConfig.getInstance(this).isDeveloper() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            //线程检测
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
        }
    }
}
