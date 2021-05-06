package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java42_动规 {
    class Solution {

        //第一想法就是滑动窗口加指针
        //因为可能是子数组只有一个数字，先找到最大值的位置，再往两边扩展
        //特喵的要用动态规划
        public int maxSubArray(int[] nums) {
            if (nums==null)return 0;
            int [] a = new int[2];
            //取出最大值的位置和值
            for (int max=0;max<nums.length;max++){
                if (nums[max]>a[1]){
                    a[1]=nums[max];
                    a[0]=max;
                }
            }


        return 0;


        }
    }
}
