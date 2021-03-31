package com.example.mzvp_java.manager;

/**
 * 作者: 991167006@qq.com
 * 创建时间: 21-1-23 下午3:51
 * 需求/缺陷:
 * 描述:　mzvp 数据key--class对相应关系封装
 */
public class MzvpEntity {

    private String mzvpId;

    private Class<?> mzvpClass;

    public Class<?> getMzvpClass() {
        return mzvpClass;
    }

    public void setMzvpClass(Class<?> mzvpClass) {
        this.mzvpClass = mzvpClass;
    }

    public String getMzvpId() {
        return mzvpId;
    }

    public void setMzvpId(String mzvpId) {
        this.mzvpId = mzvpId;
    }

}
