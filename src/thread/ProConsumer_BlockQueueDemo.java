package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/2   14:07
 */
public class ProConsumer_BlockQueueDemo {


    public static void main(String[] args) {

        ResourceData resourceData=new ResourceData(new ArrayBlockingQueue<String>(3));
        new Thread(() -> {
            try {
                resourceData.myprod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "生产者").start();

        new Thread(() -> {
            try {
                resourceData.myconsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "消费者").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("取消");

        resourceData.stop();
    }

}

class ResourceData{
    private volatile boolean flag=true;
    private AtomicInteger atomicInteger=new AtomicInteger();

    BlockingQueue<String> blockingQueue=null;

    public ResourceData(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myprod()throws Exception{
        String data=null;
        boolean retValue;
        while (flag){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println("插入" + data + "成功");
            }else {
                System.out.println("插入" + data + "失败");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "停了");
    }

    public void myconsumer() throws Exception{
        String result=null;
        while (flag){
             result = blockingQueue.poll(2L, TimeUnit.SECONDS);
             if (null==result|| result.equalsIgnoreCase("")){
                 flag=false;
                 System.out.println(Thread.currentThread().getName()+"\t 超过两秒，消费者退出");
                 return;
             }
            System.out.println(Thread.currentThread().getName() + "消费队列消费"+result+"成功");
        }
    }

    public void stop(){
        this.flag=false;
    }

}
