package recursion;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/7   14:18
 */
public class Queen8 {

    //定义一个max表示共有多少个皇后
    private int max = 8;
    private int[] array = new int[max];
    private static int count=0;
    private static int times=0;

    /**
     * @param n 第n个皇后
     */
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        times++;
        for (int i = 0; i < n; i++) {
            //判断array表示n和n-1是否是同一列
            //array斜线判断是否斜线相等可使用两个点的x轴-x轴是否等于y轴-y轴
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("共有"+count+"种算法");
        System.out.println("共计算了"+times+"次");
    }
}
