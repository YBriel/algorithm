package thread;

/**
 * @Author： yuzq
 * @Description: 非原子操作
 * @Date: 2020/1/8   9:33
 */
public class TestNum7 {

    private  int age;

    public TestNum7(int age){
        this.age=age;
    }

    public int getAge(){
        return this.age++;
    }

    public static void main(String[] args) {
        TestNum7 testNum=new TestNum7(1);
        TestNum7 testNum1=new TestNum7(1);


        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+testNum.age++);
                }
            }, String.valueOf(i)).start();
        }
    }
}
