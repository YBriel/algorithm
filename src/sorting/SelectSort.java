package sorting;

/**
 * @Author： yuzq
 * @Description: 选择排序 每一个和第一个进行交换，第一个为最小值    排序时间小于冒泡排序
 * @Date: 2020/1/8   10:36
 */
public class SelectSort {


    private int[] arr;

    public SelectSort(int[] arr) {
        this.arr = arr;
    }

    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }
            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
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
        SelectSort bubbleSort=new SelectSort(arr);
        bubbleSort.print();
        bubbleSort.selectSort(arr);
        System.out.println();
        bubbleSort.print();
    }
}
