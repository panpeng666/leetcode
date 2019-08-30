package leetcode;

import java.util.ArrayList;

public class java905 {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            for (int i=0;i<A.length;i++){
                if (A[i]%2 ==0){
                    even.add(A[i]);
                }else {odd.add(A[i]);}
            }
            even.addAll(odd);
            int [] res=new int[even.size()];
            for(int j=0;j<even.size();j++){
                res[j]=even.get(j);
            }
            return res;
        }
    }
}
