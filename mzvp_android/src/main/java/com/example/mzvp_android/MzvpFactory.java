package com.example.mzvp_android;

import android.content.Context;

import com.example.mzvp_java.manager.MzvpViewManagerImp;
import com.example.mzvp_java.support.IBaseMzvpMode;
import com.example.mzvp_java.support.IMzvpView;

import java.lang.reflect.Constructor;

public class MzvpFactory {

    public static IMzvpView<? super IBaseMzvpMode> get(IBaseMzvpMode mode, Context context) {
        Class<?> mzvpClass = MzvpViewManagerImp.getInstance().getClassById(mode.getId());
        try {
            Constructor<?> constructor = mzvpClass.getConstructor(Context.class);
            return (IMzvpView<? super IBaseMzvpMode>) constructor.newInstance(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
