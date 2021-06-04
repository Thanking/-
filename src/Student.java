

public class Student {
    public static void main(String[] args) {

        Student t1=new Student();
        t1.inverse(new int[]{1, 2, 3, 4, 5, 6, 7,8,9});
    }
    public void inverse(int[] arrayLists){
        int i=0;
        int j=0;
        int temp;
        for(j=arrayLists.length-1;i<=j;i++,j--){
            temp=arrayLists[i];
            arrayLists[i]=arrayLists[j];
            arrayLists[j]=temp;
        }
        for (Number number : arrayLists){
            System.out.println(number);
        }

    }

}
