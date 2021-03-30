package com.example.mzvp_java.support;

/**
 * 作者: xujixiong@meizu.com
 * 创建时间: 21-1-22 下午2:06
 * 需求/缺陷: 暂无需求id
 * 描述:如果View想要用attachMzvp来关联数据，可以将view继承IMzvpView
 */
public interface IMzvpView<T extends IBaseMzvpMode> {
    void attachMzvp(T data);
    T getMode();
}
