package com.example.mzvp_java.manager;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 作者: 991167006@qq.com
 * 创建时间: 21-1-22 下午2:15
 * 需求/缺陷:
 * 描述: 管理mzvp对象的key-class关系
 */
public class MzvpViewManagerImp implements IMzvpViewManager {

    private Map<String, Class<?>> stringClassMap = new LinkedHashMap<>();

    private static MzvpViewManagerImp mInstance;

    public static final String PACKAGE_NAME = MzvpViewManagerImp.class.getPackage().getName();
    public static final String MZVP_CONSTANCE_MAP_CLASS_NAME = "MzvpConstance";
    public static final String MZVP_CONSTANCE_METHOD_NAME = "getMzvpEntities";

    public static IMzvpViewManager getInstance() {
        if (mInstance == null) {
            mInstance = new MzvpViewManagerImp();
            mInstance.init();
        }
        return mInstance;
    }

    public void init() {
        attachClass();
    }

    @Override
    public void attachClass() {
        try {
            //com.example.mzvp_java.manager.MzvpConstance
            Class<?> mzvpEntitiesClass = Class.forName(PACKAGE_NAME + "." + MZVP_CONSTANCE_MAP_CLASS_NAME);
            Method mzvpEntitiesMethod = mzvpEntitiesClass.getDeclaredMethod(MZVP_CONSTANCE_METHOD_NAME);
            mzvpEntitiesMethod.setAccessible(true);
            MzvpEntity[] mzvpEntities = (MzvpEntity[]) mzvpEntitiesMethod.invoke(null);
            for (MzvpEntity entity : mzvpEntities) {
                stringClassMap.put(entity.getMzvpId(), entity.getMzvpClass());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        return stringClassMap.size();
    }

    @Override
    public Class<?> getClassById(String id) {
        if (null == id) {
            return null;
        }
        return stringClassMap.get(id);
    }

    @Override
    public int indexOfId(String id) {
        if (null == id) {
            return -1;
        }
        int index = 0;
        for (String key : stringClassMap.keySet()) {
            if (id.equals(key)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public Class<?> getClassByIndex(int index) {
        if (index >= getSize()) {
            return null;
        }
        for (String key : stringClassMap.keySet()) {
            if (index > 0) {
                index--;
            } else {
                return getClassById(key);
            }
        }
        return null;
    }

    @Override
    public Map<String, Class<?>> get() {
        return stringClassMap;
    }
}
