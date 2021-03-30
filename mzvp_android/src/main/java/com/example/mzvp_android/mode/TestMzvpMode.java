package com.example.mzvp_android.mode;

import com.example.mzvp_android.widget.TestMzvpView;
import com.example.mzvp_java.support.IBaseMzvpMode;

public class TestMzvpMode implements IBaseMzvpMode {

    public String txt;

    @Override
    public String getId() {
        return TestMzvpView.ID;
    }
}
