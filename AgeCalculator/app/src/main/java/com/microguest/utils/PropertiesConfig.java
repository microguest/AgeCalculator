package com.microguest.utils;

import android.content.Context;
import android.text.TextUtils;

import com.microguest.ACApplication;

import java.io.IOException;

/**
 * Created by wuyajun on 15-10-02.
 * <p>
 * 配置开关
 */
public class PropertiesConfig {

    private String TAG = "PropertiesConfig";
    private final String PROPERTIES_NAME = "config.properties";
    private final String TRUE = "true";

    private static PropertiesConfig moudleSwitchRWTool = null;
    private PropertiesRead2Write read2WriteProperties = null;

    public void LogI(String msg) {
        ACApplication.Logs.i(TAG, msg);
    }

    public PropertiesConfig(Context context) {
        read2WriteProperties = new PropertiesRead2Write(context, PROPERTIES_NAME);
    }

    public static PropertiesConfig getInstance(Context context) {
        if (moudleSwitchRWTool == null) {
            moudleSwitchRWTool = new PropertiesConfig(context);
        }

        return moudleSwitchRWTool;
    }

    /* 是否是开发模式 */
    public boolean isDeveloper() {
        LogI("isAutoScanOpen");
        String autoScan = null;
        try {
            autoScan = read2WriteProperties.getValue("developer.mode");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogI("autoScan:" + autoScan);
        if (TRUE.equals(autoScan)) {
            return true;
        }
        return false;
    }

    /* 获取包名 */
    public String getPackageName() {
        try {
            String skin = read2WriteProperties.getValue("package.name");
            if (!TextUtils.isEmpty(skin)) {
                return skin;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
