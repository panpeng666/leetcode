package leetcode;

/**
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 *
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 *
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-3,2,-3,4,2]
 * 输出：5
 * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 *                 累加求和
 *                 startValue = 4 | startValue = 5 | nums
 *                   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 *                   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 *                   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 *                   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 *                   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * 示例 2：
 *
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最小的 startValue 需要是正数。
 * 示例 3：
 *
 * 输入：nums = [1,-2,-3]
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//遍历整个数组，进行累加，每次累加后记录一下最小值，如果最小值小于0，return  1-min;  否则return 1
public class java1413 {
    class Solution {
        public int minStartValue(int[] nums) {
            int temp=0;
            int min=nums[0];
            for (int i:nums){
                temp+=i;
                min=Math.min(temp,min);
            }
            if (min < 0) {
                return  1-min;
            }
            return 1;
        }
    }
}
