package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/12/31   11:00
 */
public class AtomicDemo1 {

    public static List<String> strings;

    private ReentrantLock reentrantLock = new ReentrantLock();

    public AtomicDemo1() {

    }

    public void test1() {

    }

    public void test() {

        List<String> strings = new ArrayList<>();
        for (int a = 0; a < 100; a++) {
            strings.add(a + "");
        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(i);
        }


    }

    public static void main(String[] args) {
        AtomicDemo1 atomicDemo1 = new AtomicDemo1();

        for (int a = 0; a < 2; a++) {
            new Thread(atomicDemo1::test).start();
        }

    }
}
