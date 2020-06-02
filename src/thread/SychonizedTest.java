package thread;

import java.util.concurrent.TimeUnit;

/**
 * Author： yuzq
 * Description:   static synchronized 全局唯一
 *                 synchronized
 * Date: 2020/2/19   20:08
 */
public class SychonizedTest {

    private int b=6;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public SychonizedTest() {
        System.out.println(Thread.currentThread().getName()+"构造方法执行了");
    }

    public static synchronized void testA(){

            System.out.println(Thread.currentThread().getName() + "A方法开始执行");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "A方法执行完毕");

    }


    public  void testB(){
        synchronized(this) {
            System.out.println(Thread.currentThread().getName() + "B方法开始开始");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "B方法执行完毕");
        }
    }

    public synchronized void testC(){
        System.out.println(Thread.currentThread().getName()+"C方法开始执行");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"C方法执行完毕");
    }
    public static void main(String[] args) {
        SychonizedTest test=new SychonizedTest();
        SychonizedTest testB=new SychonizedTest();
           //final int a=8;
 /*       test.testC();
        test.testB();
        test.testA();*/

        new Thread(()-> {
           // test.testA();
            SychonizedTest.testA();
          //  test.testB();

        },"第一个").start();


        new Thread(new Runnable() {
           // a++;
            @Override
            public void run() {
               // SychonizedTest.testA();
                testB.testB();
               // test.testA();
                //testB.testB();
                //a=2;
            }
        },"第二个").start();

        new Thread(() -> {
           // test.testA();
           // test1.testA();
        }, "第三个").start();
    }
}
