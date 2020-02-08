package sorting;

import java.util.Arrays;

/**
 * @Author： yuzq
 * @Description: 插入排序
 * @Date: 2020/1/8   10:59
 * 固定第一个，用后面的数逐个比较
 */
public class InsertSort {

    private void insertSortDemo1(){
        int[] arr={101,34,119,2};
        for(int i=0;i<arr.length;i++){
            int insertVal=arr[i];
            int insertIndex=i-1;
            //给InsertVal找到插入的位置
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
            System.out.println("第"+i+"轮插入.");
            System.out.println(Arrays.toString(arr));
        }
/*        int[] arr={101,34,119,2};
        //首先第二个数需要与第一个进行比较
        int insertVal=arr[1];
        int insertIndex=0;
        //给InsertVal找到插入的位置
        while (insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=insertVal;*/


    }

    private void insertSort(int[] arr){
        int temp;
        for (int i=1;i<arr.length;i++){
            //待排元素小于有序序列的最后一个元素时，向前插入
            if (arr[i]<arr[i-1]){
                temp = arr[i];
                for (int j=i;j>=0;j--){
                    if (j>0 && arr[j-1]>temp) {
                        arr[j]=arr[j-1];
                    }else {
                        arr[j]=temp;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {

        InsertSort sort=new InsertSort();
        sort.insertSortDemo1();
    }
}
