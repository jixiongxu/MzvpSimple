package com.example.mzvp;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mzvp_android.MzvpFactory;
import com.example.mzvp_android.mode.TestMzvpMode;
import com.example.mzvp_java.support.IBaseMzvpMode;
import com.example.mzvp_java.support.IMzvpView;

public class MainActivity extends Activity {

    private LinearLayout mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentLayout = findViewById(R.id.content_layout);

        TestMzvpMode mode = new TestMzvpMode();
        mode.txt = "this is mzvp ";
        IMzvpView<? super IBaseMzvpMode> iMzvpView = MzvpFactory.get(mode, this);
        if (iMzvpView != null) {
            mContentLayout.addView((View) iMzvpView);
            iMzvpView.attachMzvp(mode);
        }
    }
}