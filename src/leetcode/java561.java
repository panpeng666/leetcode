package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class java561 {
   static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int result=0;
            for (int i=0;i<nums.length;i++){
            if (i%2==0){
                System.out.println(nums[i]);
                result=result+nums[i];
            }
            }
            return result;
        }
        }

    public   static void main(String[] args) {
        Solution solution = new Solution();
        int [] num = {1,2,3,4};
        System.out.println(solution.arrayPairSum(num));

    }
}
