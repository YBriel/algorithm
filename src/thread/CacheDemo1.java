package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/1   17:24
 */
public class CacheDemo1 {

    private volatile Map<String,Object> map=new HashMap<>();

    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println("正在写入  "+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300); //模拟网络延迟休眠300毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println("写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }


    public void get(String key){
        readWriteLock.readLock().lock();
       try {
           System.out.println("正在读取");
           try {
               TimeUnit.MILLISECONDS.sleep(300);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           Object result = map.get(key);
           System.out.println("读取完成  "+result);
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           readWriteLock.readLock().unlock();
       }
    }


    public static void main(String[] args) {
        CacheDemo1 cacheDemo=new CacheDemo1();
        for (int i = 0; i < 6; i++) {
            final  int temp=i;
            new Thread(() -> {
                cacheDemo.put(temp+"",temp);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 6; i++) {
            final  int temp=i;
            new Thread(() -> {
                cacheDemo.get(temp+"");
            }, String.valueOf(i)).start();
        }
    }
}
