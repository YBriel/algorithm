package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/2   14:52
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        //futureTask.
        Thread thread=new Thread(futureTask,"AAA");
        thread.start();
        System.out.println(futureTask.get());

    }

}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("哈哈哈");
        return 1024;
    }
}
