package thread;

/**
 * @Author： yuzq
 * @Description: 非原子操作
 * @Date: 2020/1/8   9:33
 */
public class TestNum6 {

    private  int age;

    public TestNum6(int age){
        this.age=age;
    }

    public int getAge(){
        return this.age++;
    }

    public static void main(String[] args) {
        TestNum6 testNum=new TestNum6(1);
        TestNum6 testNum1=new TestNum6(1);

        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                System.out.println(Thread.currentThread().getName()+"---->"+testNum.age++);
            }
        }, "AAA").start();

    }
}
