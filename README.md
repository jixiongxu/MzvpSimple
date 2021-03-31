# Mzvp

> Mzvp 框架致力于解决安卓中控件管理和复用。使用分为三部：
> 1、自定义控件继承于IMzvpView 实现接口方法attachMzvp 这个方法用于将数据填充到控件进行展示。
> 2、添加控件的数据结构并实现IBaseMzvpMode ，返回的id必须和@MzvpBind("")注解的内容一样才能找到这个控件。
> 3、使用的时候只需要MzvpFactory.get（）即可获取到对应的控件。

# 优点
> 完全可以通过数据去获取控件，可以通过数据配置将页面布局成想要的效果。
