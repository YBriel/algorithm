package thread;

import java.util.concurrent.Semaphore;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/17   8:36
 */
public class SemaphoreDemo2 {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(1);
        for (int i = 0; i < 5; i++) {
            int tem=i;
            for (int j = 0; j < 3; j++) {
                new Thread(() -> {
                    System.out.println("AAA第："+tem+"次");
                }, "AAA").start();
            }
        }
    }

}
