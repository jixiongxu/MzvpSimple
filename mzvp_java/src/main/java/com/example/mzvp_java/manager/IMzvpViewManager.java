package com.example.mzvp_java.manager;

import com.example.mzvp_java.support.MzvpBind;

import java.util.Map;

/**
 * 作者: xujixiong@meizu.com
 * 创建时间: 21-1-22 下午2:15
 * 需求/缺陷:暂无需求id
 * 描述: 管理mzvp对象的key-class关系
 */
public interface IMzvpViewManager {
    /**
     * 在编译阶段会扫描本地被
     * {@link MzvpBind }
     * 标注的对象，保存他们的信息
     */
    void attachClass();

    int getSize();

    Class<?> getClassById(String id);

    int indexOfId(String id);

    Class<?> getClassByIndex(int index);

    Map<String, Class<?>> get();
}
