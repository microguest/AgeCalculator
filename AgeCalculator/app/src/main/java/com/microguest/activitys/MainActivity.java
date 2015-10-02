package com.microguest.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.microguest.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.microguest.utils.PropertiesConfig;

/**
 * Created by wuyajun on 15/10/2.
 */
@EActivity(R.layout.activity_main) //引入界面布局
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ViewById
    TextView text;

    @AfterViews
    void initTestData() {

        text.setText("Hello AndroidAnnotations   " + PropertiesConfig.getInstance(MainActivity.this).isDeveloper());
    }
}