package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author： yuzq
 * @Description:
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，调用线程会被阻塞。其他线程调用countDown方法会将计数器减1
 * （调用CountDown方法的线程不会阻塞），当计数器的值变为0时，因调用await方法被阻塞的线程会被唤醒，继续执行。
 * @Date: 2020/1/2   9:15
 */
public class CountdownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"离开...");
                countDownLatch.countDown();
            }, CountryEnum.forEachCountry(i)!=null ? (CountryEnum.forEachCountry(i).getRetMsg()==null?"ss":CountryEnum.forEachCountry(i).getRetMsg()):"ss").start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"主线程走了");
    }
}
