package recursion;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/7   9:57
 */
public class RecursionDemo {

    public static void main(String[] args) {
        //RecursionDemo recursionDemo=new RecursionDemo();
        //RecursionDemo.test(4);
        System.out.println(RecursionDemo.factorial(4));
    }

    public  static void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }else {
           return factorial(n-1)*n;
        }
    }
}
