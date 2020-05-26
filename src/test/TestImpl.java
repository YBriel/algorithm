package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/1/31   8:25
 */
public class TestImpl extends AbsTest {

    public TestImpl() {
        super(30);
    }

    public static void main(String[] args) {
      /*  TestImpl test=new TestImpl();
        System.out.println(test.getPower());*/
        //Class<DynamicProxy> proxyClass = DynamicProxy.class;
        DynamicProxy dynamicProxy=new DynamicProxy();
        Class<? extends DynamicProxy> aClass = dynamicProxy.getClass();

        try {
            Method sayHello = aClass.getMethod("sayHello",String.class,int.class);
            sayHello.invoke(dynamicProxy,"s",22);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
