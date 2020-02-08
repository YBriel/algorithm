package thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author： yuzq
 * @Description: 同步队列
 * @Date: 2020/1/2   12:26
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue<String> strings = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println("放入a");
                strings.put("a");
                System.out.println("放入b");
                strings.put("b");
                System.out.println("放入c");
                strings.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();
        new Thread(() -> {
            try {
                strings.take();
                System.out.println("取出a");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("取出b");
                strings.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
