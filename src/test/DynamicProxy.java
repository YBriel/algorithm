package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   12:07
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    private Object bind(Object object){
        this.object=object;
        //return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    public void sayHello(String a,int b){
        System.out.println("Hello ..."+a+b);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        try {
            validateUser();
            result=method.invoke(object,args);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private void validateUser(){
        System.out.println("验证....");
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy=new DynamicProxy();
        IHello hello = (IHello)dynamicProxy.bind(new Hello());
        hello.sayHello();
        hello.sayHello1();
        hello.sayHello2();

    }
}
