package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

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
        /*BigDecimal bigDecimal=new BigDecimal(2.00232);
        BigDecimal bigDecimal1 = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal1.toEngineeringString());
        System.out.println(bigDecimal1.toPlainString());
        System.out.println(bigDecimal1.toString());*/

        BigDecimal productPrice=new BigDecimal("0");
        BigDecimal scalePrice = productPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        List<Float> floats=new ArrayList<>();
        floats.add(5.66f);
        floats.add(6.66f);
        floats.add(5.266f);
        floats.add(15.66f);
        floats.add(115.6633f);
       // BigDecimal add=new BigDecimal(0);
        for (Float aFloat : floats) {
            BigDecimal temp=new BigDecimal(aFloat);
            BigDecimal temp1 = temp.setScale(2, BigDecimal.ROUND_HALF_UP);
            scalePrice  = scalePrice.add(temp1);
        }
        System.out.println(scalePrice);

    }
}
