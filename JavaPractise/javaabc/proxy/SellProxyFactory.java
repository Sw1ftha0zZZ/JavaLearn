package javaabc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理工厂需要实现InvocationHandler接口，并重写invoke方法
 */
public class SellProxyFactory implements InvocationHandler {

    private Object realObject;
    public SellProxyFactory(Object realObject) {
        this.realObject = realObject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object obj = method.invoke(realObject, args);
        doSomethingAfter();
        return obj;
    }
    private void doSomethingAfter() {
        System.out.println("after...");
    }
    private void doSomethingBefore() {
        System.out.println("before...");
    }
}