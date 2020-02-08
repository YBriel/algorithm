package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/2   15:52
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
       // ExecutorService service = Executors.newFixedThreadPool(3); //固定3个线程
       // ExecutorService service = Executors.newSingleThreadExecutor(); //固定3个线程
        ExecutorService service = Executors.newCachedThreadPool(); //可变的
        try {
            for (int i = 0; i < 10; i++) {
                service.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t"+"办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
