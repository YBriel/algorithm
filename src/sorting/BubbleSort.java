package sorting;

/**
 * @Author： yuzq
 * @Description: 冒泡排序 时间复杂度是o(n^2) 两两交换顺序
 * @Date: 2020/1/8   10:12
 */
public class BubbleSort {

    private int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    private void sort(int[] arr) {
        int temp ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void print() {
        for (int a : arr) {
            System.out.print(a+"\t");
        }
    }

    public static void main(String[] args) {
        int[] arr={3,11,-1,-23,12};
        BubbleSort bubbleSort=new BubbleSort(arr);
        bubbleSort.print();
        bubbleSort.sort(arr);
        System.out.println();
        bubbleSort.print();
    }
}
