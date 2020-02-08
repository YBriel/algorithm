package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author： yuzq
 * @Description: 生产者消费者传统模式
 * @Date: 2020/1/2   12:46
 * 初始值为0的变量，两个线程对齐交替操作 1个加一个减 5次
 */
public class ProConsumer_Tranditional {

    public static void main(String[] args) {
        ShareData share=new ShareData();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    share.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "SSS").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    share.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "BBB").start();
        }
    }
}

class ShareData {
    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() throws Exception {

        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "  " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "  " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
