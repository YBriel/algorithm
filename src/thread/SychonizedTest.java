package thread;

import java.util.concurrent.TimeUnit;

/**
 * Author： yuzq
 * Description:
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

    public static synchronized void testA(){
        System.out.println("A方法开始执行");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"AAAAAA");
        System.out.println("A方法开始完毕");
    }


    public  synchronized void testB(){
        System.out.println("B方法开始开始");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"BBB");
        System.out.println("B方法开始完毕");
    }

    public void testC(){
        System.out.println("C方法开始开始");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"CCC");
        System.out.println("C方法开始完毕");
    }
    public static void main(String[] args) {
        SychonizedTest test=new SychonizedTest();
        SychonizedTest test1=new SychonizedTest();
           //final int a=8;
 /*       test.testC();
        test.testB();
        test.testA();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testA();
                test.testB();
            }
        },"第一个").start();


        new Thread(new Runnable() {
           // a++;
            @Override
            public void run() {
                test1.testA();
                test1.testB();
                //a=2;
            }
        },"第二个").start();
    }
}
