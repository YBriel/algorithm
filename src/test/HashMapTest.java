package test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/1/30   11:12
 */
public class HashMapTest {

    public static void main(String[] args) {
  /*      HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put(null,"ss");
        hashMap.put(null,"ssss");
        System.out.println(hashMap.size());
        System.out.println(hashMap.get(null));

        Hashtable<String,String> hashtable=new Hashtable<>();
        hashtable.put(null,"ss");*/
        BigDecimal bigDecimal=new BigDecimal(2.00232);
        BigDecimal bigDecimal1 = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal1.toEngineeringString());
        System.out.println(bigDecimal1.toPlainString());
        System.out.println(bigDecimal1.toString());
    }
}
