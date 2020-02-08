package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author： yuzq
 * @Description: 原子操作 getAndIncrement
 * @Date: 2020/1/8   9:33
 */
public class TestNum5 {

    //private volatile int age;
    private  AtomicInteger age;

    private TestNum5(AtomicInteger age){
        this.age=age;
    }

    private int getAge(){
        return this.age.getAndIncrement();
    }

    public static void main(String[] args) {
        TestNum5 testNum=new TestNum5(new AtomicInteger(1));
        TestNum5 testNum1=new TestNum5(new AtomicInteger(1));

        new Thread(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+testNum.getAge());
                }
            }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"---->"+testNum1.getAge());
            }
        }, "BBB").start();

    }
}
