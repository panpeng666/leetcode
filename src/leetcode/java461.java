package leetcode;

/**
 * 两个整数之间的汉明距离是相应位不同的位置数。
 *
 * 给定两个整数，x并y计算汉明距离。
 *
 * 注意：
 * 0≤ x，y<2 31。
 *
 * 例：
 *
 * 输入： x = 1，y = 4
 *
 * 输出： 2
 *
 * 说明：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上述箭头指向相应位不同的位置。
 */
public class java461 {
    static class Solution {
         public int hammingDistance(int x, int y) {
             int i=x^y;
            System.out.println(i);
          return 3;
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.hammingDistance(1,4);
    }
}
