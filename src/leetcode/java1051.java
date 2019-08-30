package leetcode;

import java.util.Arrays;

public class java1051 {
    static class Solution {
        public int heightChecker(int[] heights) {
            int [] temp = heights.clone();
            Arrays.sort(heights);

            int result=0;
            for(int i=0;i<heights.length;i++){

                if (heights[i]!=temp[i]){

                    result++;
                }
            }
            return result;
        }
        public   static void main(String[] args) {
            Solution solution = new Solution();
          int [] a = {1,1,4,2,1,3};
          System.out.println(solution.heightChecker(a));
        }
    }
}
