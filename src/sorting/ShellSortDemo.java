package sorting;

import java.util.Arrays;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/10   10:40
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        int[] arr={8,9,1,7,2,3,5,4,6,0};
        ShellSortDemo.shellSort(arr);
    }

    private static void shellSort(int[] arr){
        int temp;
        for(int i=5;i<arr.length;i++){
            for(int j=i-5;j>=0;j-=5){
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
