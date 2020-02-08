package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author： yuzq
 * @Description: 原子操作 getAndIncrement
 * @Date: 2020/1/8   9:33
 */
public class TestNum3 {

    //private volatile int age;
    private volatile AtomicInteger age;

    private TestNum3(AtomicInteger age){
        this.age=age;
    }

    private int getAge(){
        return this.age.getAndIncrement();
    }

    public static void main(String[] args) {
        TestNum3 testNum=new TestNum3(new AtomicInteger(1));
        TestNum3 testNum1=new TestNum3(new AtomicInteger(1));

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
