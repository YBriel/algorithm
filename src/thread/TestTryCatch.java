package thread;

/**
 * author: yuzq
 * create: 2020-04-02 14:45
 **/
public class TestTryCatch {

    public int say(){
        try {
            int a=100;
            int c=100/0;
            return a*100;
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            System.out.println("finally执行了");
        }
        return 2;
}

    public static void main(String[] args) {
        TestTryCatch testTryCatch=new TestTryCatch();
        System.out.println(testTryCatch.say());

    }
}
