package Arrays;

import java.util.Arrays;

/**
 * @author : zpx
 * @version : 1.0
 * @ClassName : ArraySort
 * @Description : TODO
 * @date : 2021/6/4 18:08
 * 冒泡排序
 **/
public class ArraySort {


    public static void main(String[] args) {
        int[] arr = {22,15,5,87,56,45,84};
        int[] sorts =  arrSort(arr);
        System.out.println(Arrays.toString(sorts));
    }


    public static int[] arrSort(int[] arr){
        boolean flat = false;
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    count = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = count;
                    flat = true;
                }
                if (flat){
                    break;
                }
            }
        }

        return arr;
    }
}
