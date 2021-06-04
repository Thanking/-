package Arrays;

/**
 * @author : zpx
 * @version : 1.0
 * @ClassName : ArrayDemo
 * @Description : TODO
 * @date : 2021/6/4 17:24
 * 转稀疏矩阵
 **/
public class ArrayDemo {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[3][4] = 1;
        arr[2][6] = 2;
        //记录数值个数
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        //定义稀疏矩阵
        int[][] arr1 = new int[sum + 1][3];
        arr1[0][0] = arr.length;
        arr1[0][1] = arr.length;
        arr1[0][2] = sum;
        //转化
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    arr1[count][0] = i;
                    arr1[count][1] = j;
                    arr1[count][2] = arr[i][j];
                }
            }
        }
        //打印
        for (int a = 0; a < arr1.length; a++) {
            System.out.println(arr1[a][0] + "\t"
                    + arr1[a][1] + "\t"
                    + arr1[a][2] + "\t");
        }

        //还原
        int[][] arr2 = new int[arr1[0][0]][arr1[0][1]];
        for (int i = 1; i < arr1.length; i++) {
            arr2[arr1[i][0]][arr1[i][1]] = arr1[i][2];
        }

        for (int[] ints : arr2) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

}
