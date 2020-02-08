package jvm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/3   10:29
 */
public class JvmDemo {

    public static void main(String[] args) throws InterruptedException {
      //  System.out.println("hhhh");
       // Thread.sleep(Integer.MAX_VALUE);
        List<String> strings=new ArrayList<>();
        strings.add("还好");
        strings.add("ss");
        strings.add("进阶");
        strings.add("按错");
        strings.add("让他");
        System.out.println(strings.get(2));
        strings.add(3,"我还");


    }
}
