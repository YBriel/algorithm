package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/12/31   11:14
 */
public class ThreadTest1 {

    public void test(){
        int a=10;
        while (a>0)
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            a--;
        }
    }
}
