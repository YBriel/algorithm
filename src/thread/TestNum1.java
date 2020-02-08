package thread;

/**
 * @Author： yuzq
 * @Description: 非原子操作
 * @Date: 2020/1/8   9:33
 */
public class TestNum1 {

    private volatile int age;

    public TestNum1(int age){
        this.age=age;
    }

    public int getAge(){
        return this.age++;
    }

    public static void main(String[] args) {
        TestNum1 testNum=new TestNum1(1);
        TestNum1 testNum1=new TestNum1(1);

            new Thread(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+testNum.getAge());
                }
            }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"---->"+testNum1.getAge());
            }
        }, "BBB").start();

    }
}
