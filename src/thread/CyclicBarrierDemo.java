package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author： yuzq
 * @Description:
 * CyslicBarrier的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，让一组线程到达屏障（也可以叫同步点）
 * 时被阻塞，直到最后一个线程到达屏障时，屏障才会打开门，所有被屏障拦截的线程才会继续干活，
 * 线程进入屏障通过CyclicBarrier的await（）方法。
 * @Date: 2020/1/2   10:52
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("收集成功！");
        });

        for (int i = 0; i < 7; i++) {
            final int intTemp=i;
            new Thread(() -> {
                System.out.println("收集到第"+intTemp+"颗");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

}
