package com.example.mzvp_java.support;


/**
 * 作者: xujixiong@meizu.com
 * 创建时间: 21-1-22 下午1:59
 * 需求： 暂无需求id
 * 描述: 用来存储被{@link MzvpBind#value()} 标注的id，通过这个id去查询对象实例
 */
public interface IBaseMzvpMode {

    /**
     * 需要在 {@link MzvpBind#value()} 标注过才能被查找到
     *
     * @return key
     */
    public String getId();

}
