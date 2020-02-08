package thread;


import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test2 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("第" + i + "条");
        }
        long long1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            try {
                new Thread(new Runnable() {
                    List<Object> listresult = new ArrayList<>();
                    @Override
                    public void run() {
                        System.out.println("第" + Thread.currentThread().getName());
                        for (String cqz : list) {
                            System.out.println(cqz);
                        }
                    }
                }).start();
            } finally {
                lock.unlock();
            }

        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        long long2 = System.currentTimeMillis();
        System.out.println(long1 - long2);
    }

}