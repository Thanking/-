


import java.io.*;
import java.util.Scanner;

public class Test {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length; //读取数据长度

        aux = new Comparable[N];
        for (int size = 1; size < N; size = size + size)
            for (int lo = 0; lo < N - size; lo += size + size)
                merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
            System.out.println(aux);
       /* //希尔排序
        int h = 1;
        while (h<N/3) h = 3*h + 1;//1,4,13,40,121
        while (h>=1){
            for (int i = 1;i<N;i++){
                for (int j = i;j>=h && less(a[j],a[j-h]);j -= h)
                    exch(a,j,j-h);
            }
            h = h/3;
        }
        */
       /* //插入排序
        for (int i = 0;i<N;i++){//将a[i]插入a[i-1]、a[i-2]....中
            for (int j = i;j>0 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
        }
        */
       /* //选择排序
        for (int i=0;i<N;i++){//将a[i]和a[i+1..N]中最小的元素交换
            int min = i;        //最小元素的索引
            for (int j = i+1;j < N;j++)
                if (less(a[j],a[min])) min = j;
            exch(a,i,min);
        }*/

    }

    //原地归并抽象
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[j++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];

    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;

    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
//        File f = new File("E:\\IDEA_Project\\untitled\\src\\tiny.txt");
//
//        InputStreamReader inputStream = new InputStreamReader(new FileInputStream(f), "UTF-8");
//        BufferedReader br = new BufferedReader(inputStream);
        Scanner in = new Scanner(System.in);
        // String[] a = new In("E:\\IDEA_Project\\untitled\\src\\tiny.txt").readAllStrings();
        String str = in.next();

        String[] a = str.split("");
        sort(a);
        assert isSorted(a);
        show(a);

    }


}

