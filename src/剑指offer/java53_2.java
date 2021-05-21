package 剑指offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java53_2 {
    class Solution {
        public int missingNumber(int[] nums) {
            if (nums[0]!=0)return 0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]!=i){
                    return i;
                }
            }
            return nums.length;
        }
        //可以走二分法
        public int missingNumber2(int[] nums) {
            int left=0;
            int right=nums.length-1;
            int temp ;

            while (left<=right){
                temp = (right+left)/2;
                if (nums[temp]==temp){
                    left=temp+1;
                }else {right=temp-1;}
            }
            return left;

        }
    }
}
