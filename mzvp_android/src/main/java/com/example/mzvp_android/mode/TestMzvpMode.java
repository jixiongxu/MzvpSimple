package com.example.mzvp_android.mode;

import com.example.mzvp_android.widget.TestMzvpView;
import com.example.mzvp_java.support.IBaseMzvpMode;
/**
 * 作者: 991167006@qq.com
 * 创建时间: 21-1-22 下午2:06
 * 需求/缺陷: 暂无需求id
 * 描述:TestMzvpView这个控件的数据
 */
public class TestMzvpMode implements IBaseMzvpMode {

    public String txt;

    @Override
    public String getId() {
        return TestMzvpView.ID;
    }
}
