package queue;

import java.util.Stack;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/6   11:06
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String> strings=new Stack<>();
        strings.push("tom");
        strings.push("jerry");
        strings.push("anna");
        strings.push("peter");

     while (!strings.empty()){
         System.out.println(strings.pop());
     }
    }
}
