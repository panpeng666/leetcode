package test;

import org.testng.internal.Utils;

public class CountSort{
    public static void main(String[] args){
        int [] A = {-1, 2, 0, 4, 3, 6, 5, 8, -2, 1, 3, 0, 3, 6, 5, 2};
        countSort(A);
        for(int index = 0; index < A.length; index++)
            System.out.print(A[index] + "  ");

    }

    private static void countSort(int[] A){
        int len=A.length;
        int max=0;
        int min=0;
        for(int i=0;i<len;i++){
            if (A[i]<min){
                min = A[i];
                continue;
            }
            if (A[i]>max) max=A[i];
        }
        int[] B= new int[max-min+1];
        for (int i:A){
            int temp = i-min;
            B[temp]++;
        }
        int[] C=new int[len];
        int a=0;
        for(int j=0;j<B.length;j++){
            for(int count=0;count<B[j];count++){
             A[a++]=j+min;
            }
        }
    }
//    private static void countSort1(int [] A) {
//        int min = 0, max = 0;
//        int [] C = null;
//        for(int index = 0; index < A.length; index++) {
//            if(A[index] < min) {
//                min = A[index];
//                continue;
//            }
//            if(A[index] > max)	max = A[index];
//        }
//        C = new int[max - min + 1];
//        for(int index = 0; index < A.length; index++) {
//            C[A[index] - min]++;
//        }
//        int a = 0;
//        for(int index = 0; index < C.length; index++) {
//            for(int count = 0; count < C[index]; count++){
//                A[a++] = index + min;
//            }
//        }
//    }


}

