package com.example.mzvp_java.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者: 991167006@qq.com
 * 创建时间: 21-1-22 下午1:53
 * 需求：暂无需求id
 * 描述: 用来标注view。被标注的对象必须继承与view或者view的子类
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface MzvpBind {
    String value() default "";
}
