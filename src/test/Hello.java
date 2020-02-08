package test;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   12:17
 */
public class Hello implements IHello {
    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void sayHello1() {
        System.out.println("Hello1");
    }

    @Override
    public void sayHello2() {
        System.out.println("Hello2");
    }
}
