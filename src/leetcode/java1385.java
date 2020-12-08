package leetcode;

/**
 * https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays/
 */
public class java1385 {
    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int res=0;
            for (int i:arr1){
                res++;
                for (int j:arr2){
                    int temp=i-j;
                    if (temp<0){temp=-temp;}
                    if (temp<=d){
                        res--;
                        System.out.println(i+" "+j + "不符合");
                        break;
                    }
                }
            }
            return res;
        }
    }
}
