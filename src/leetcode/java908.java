package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
题目的意思是有一个数x，x的范围是-K<x<K，然后给A数组内所有数字加上这个x，使得，A里面的差值最小
目前的思路是先sort A，取首尾既是A的最大最小值，然后遍历-k-k，来算？
 */

public class java908 {
    class Solution {
        public int smallestRangeI(int[] A, int K) {
            if (A.length==1){return 0;}
            Arrays.sort(A);
            int MAX=A[A.length-1];
            int MIN=A[0];
            if (MAX-MIN<=2*K){
                return 0;
            }

            else return MAX-MIN-2*K;
        }
    }
}
