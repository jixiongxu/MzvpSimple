package com.example.mzvp_android.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mzvp_android.R;
import com.example.mzvp_android.mode.TestMzvpMode;
import com.example.mzvp_java.support.IMzvpView;
import com.example.mzvp_java.support.MzvpBind;

/**
 * 作者: 991167006@qq.com
 * 创建时间: 21-1-22 下午2:06
 * 需求/缺陷: 暂无需求id
 * 描述:自定义控件TestMzvpView
 */
@MzvpBind(TestMzvpView.ID)
public class TestMzvpView extends LinearLayout implements IMzvpView<TestMzvpMode> {

    public static final String ID = "TestMzvpView";

    private TextView mText;

    private TestMzvpMode mode;

    public TestMzvpView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-2, -1));
        initView();
    }

    @Override
    public void attachMzvp(TestMzvpMode data) {
        mode = data;
        mText.setText(data.txt);
    }

    @Override
    public TestMzvpMode getMode() {
        return mode;
    }

    private void initView() {
        View mRoot = inflate(getContext(), R.layout.mzvp_test_layout, null);
        mText = mRoot.findViewById(R.id.id_test_txt);
        addView(mRoot);
    }
}
