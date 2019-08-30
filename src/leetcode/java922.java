package leetcode;

import java.util.ArrayList;

public class java922 {
    /**
     *
     */
 static    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int len =A.length;
            int[] a1 = new int [len/2];
            int[] a2 = new int [len/2];
            int[] B = new int[len];
            int c=0;
            int d=0;
            for(int i=0;i<len;i++){

                if (A[i]%2==0){
                    a1[c]=A[i];
                    System.out.println("a1+"+A[i]+"weizhi is a1{"+c);
                    c++;

                }else {
                    a2[d]=A[i];
                    System.out.println("a2+"+A[i]+"weizhi is a2{"+d);
                    d++;

                }
            }
            for(int temp:a1){
                System.out.print(temp);
            }
            for(int temp:a2){
                System.out.print(temp);
            }
            c=0;
            d=0;
            for(int j=0;j<len;j++){

                if (j%2==0){
                    B[j]=a1[c];
                    c++;
                }else {
                    B[j]=a2[d];
                    d++;
                }


            }


            return B;
        }
    }
    public   static void main(String[] args) {
        Solution solution = new Solution();
        int [] a = {1,1,4,2,4,3};
        int [] b = solution.sortArrayByParityII(a);
        for(int temp:b){
            System.out.println(temp);
        }
    }

    class Solution1 {
        public int[] sortArrayByParityII1(int[] A) {
           int len = A.length;
           int[] result = new int[len];
           int i=0;
           int j=1;
           for(int a:A){
               if (a%2==0){
                   result[i]=a;
                   i+=2;
               }else {
                   result[j]=a;
                   j+=2;
               }
           }
           return result;
        }
        public int[] sortArrayByParityII2(int[] A) {
        int len=A.length;
        for(int i=0;i<len;i++){
            int j=i+1;
            if (i%2==0&&A[i]%2==1){
                while (A[j]%2==0){
                    int temp=A[i];
                    A[i]=A[j];
                    A[j]=temp;
                    j++;
                }

            }


        }
            return A;
        }
        }

    }



