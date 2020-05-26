package interview;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/14   15:57
 */
public class Demo2Son extends Demo2Fathar {

    private int i=test();

    private static int j=method();

    static {
        System.out.println(6);
    }

    Demo2Son(){
        System.out.println(7);
    }

    {
        System.out.println(8);
    }
    private int test() {

        System.out.println(9);
        return 1;
    }

    private static int method() {

        System.out.println(10);
        return 1;
    }
}
