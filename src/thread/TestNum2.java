package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author： yuzq
 * @Description: 原子操作 incrementAndGet
 * @Date: 2020/1/8   9:33
 */
public class TestNum2 {

    //private volatile int age;
    private volatile AtomicInteger age;

    private TestNum2(AtomicInteger age){
        this.age=age;
    }

    private int getAge(){
        return this.age.incrementAndGet();
    }

    public static void main(String[] args) {
        TestNum2 testNum=new TestNum2(new AtomicInteger(1));
        TestNum2 testNum1=new TestNum2(new AtomicInteger(1));

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
