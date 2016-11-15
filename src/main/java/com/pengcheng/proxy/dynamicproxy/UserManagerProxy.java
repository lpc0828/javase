package com.pengcheng.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/11/13.
 */
public class UserManagerProxy implements InvocationHandler {

    private Object proxyObject;

    public Object newProxyInstance(Object proxyObject) {
        this.proxyObject = proxyObject;
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), proxyObject.getClass().getInterfaces(), this);
    }



    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preInvoke();
        System.out.println("args="+ args);
        Object ret = method.invoke(proxyObject, args);
        System.out.println("ret=" + ret);
        postInvoke();
        return ret;
    }

    private void preInvoke() {
        System.out.println("preInvoke do");
    }

    private void postInvoke() {
        System.out.println("postnvoke do");
    }

}
