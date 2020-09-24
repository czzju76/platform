package com.platform.pattern.Observer.updateForDelegate;

import java.lang.reflect.Method;

/**
 * @Title: Event
 * @Description:
 * @Auther:Lyon Chen
 * @Version: 1.0
 * @create 2020/9/24 17:03
 */
public class Event {
    private Object object;

    private String methodName;

    private Object[] params;

    private Class[] paramTypes;

    public Event(Object object,String method,Object...args)
    {
        this.object = object;
        this.methodName = method;
        this.params = args;
        contractParamTypes(this.params);
    }

    private void contractParamTypes(Object[] params)
    {
        this.paramTypes = new Class[params.length];
        for (int i=0;i<params.length;i++)
        {
            this.paramTypes[i] = params[i].getClass();
        }
    }

    public void invoke() throws Exception
    {
        Method method = object.getClass().getMethod(this.methodName, this.paramTypes);//判断是否存在这个函数
        if (null == method)
        {
            return;
        }
        method.invoke(this.object, this.params);//利用反射机制调用函数
    }
}