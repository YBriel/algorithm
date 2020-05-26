package interview;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/14   15:44
 */
public class Demo2Fathar {

    private int i=test();

    private static int j=method();

    static {
        System.out.println(1);
    }

    Demo2Fathar(){
        System.out.println(2);
    }

    {
        System.out.println(3);
    }

    private int test() {

        System.out.println(4);
        return 1;
    }

    private static int method() {

        System.out.println(5);
        return 1;
    }


}
