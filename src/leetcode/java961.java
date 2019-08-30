package leetcode;

public class java961 {

    class Solution {
        public int repeatedNTimes(int[] A) {
            int res=0;
            for(int i=0;i<A.length;i++){
                for (int j=i+1;j<A.length;j++){
                    if(A[i]==A[j]){
                        res= A[i];
                        break;
                    }
                }

            }
            return res;
        }
    }
}
