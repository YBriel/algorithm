package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/1   17:24
 */
public class CacheDemo {

    private volatile Map<String,Object> map=new HashMap<>();

    public void put(String key,Object value){
        System.out.println("正在写入  "+key);
        try {
            TimeUnit.MILLISECONDS.sleep(300); //模拟网络延迟休眠300毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key,value);
        System.out.println("写入完成");
    }


    public void get(String key){
        System.out.println("正在读取");
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object result = map.get(key);
        System.out.println("读取完成  "+result);
    }


    public static void main(String[] args) {
        CacheDemo cacheDemo=new CacheDemo();
        for (int i = 0; i < 5; i++) {
            final  int temp=i;
            new Thread(() -> {
                cacheDemo.put(temp+"",temp);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final  int temp=i;
            new Thread(() -> {
                cacheDemo.get(temp+"");
            }, String.valueOf(i)).start();
        }
    }
}
