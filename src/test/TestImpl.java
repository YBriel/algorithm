package test;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/1/31   8:25
 */
public class TestImpl extends AbsTest {

    public TestImpl() {
        super(30);
    }

    public static void main(String[] args) {
        TestImpl test=new TestImpl();
        System.out.println(test.getPower());
    }
}
