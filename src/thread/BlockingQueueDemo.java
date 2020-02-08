package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author： yuzq
 * @Description: 阻塞队列
 * @Date: 2020/1/2   11:24
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        //List<String> strings=new ArrayList<>();
//        System.out.println(Integer.MAX_VALUE);
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

        //add方法超出界限报错

/*        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());*/

//offer方法返回true or false
/*        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //无原素返回Null
        System.out.println(blockingQueue.peek());*/

        //put方法
        try {
            blockingQueue.put("a");
            blockingQueue.put("b");
            blockingQueue.put("c");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*        try {

            blockingQueue.offer("a",2L, TimeUnit.SECONDS);
            blockingQueue.offer("b",2L, TimeUnit.SECONDS);
            blockingQueue.offer("c",2L, TimeUnit.SECONDS);
            blockingQueue.offer("d",2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
