package com.microguest.activitys;

import android.os.Bundle;
import android.widget.TextView;

import com.microguest.R;
import com.microguest.utils.PropertiesConfig;

import roboguice.inject.InjectView;

/**
 * Created by wuyajun on 15/10/2.
 */
public class MainActivity extends ACBaseActivity {

    @InjectView(R.id.text)
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text.setText("" + PropertiesConfig.getInstance(this).isDeveloper());
    }


}