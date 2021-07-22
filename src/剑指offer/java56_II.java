package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;

public class java56_II {
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *  
     *
     * 限制：
     *
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public int singleNumber(int[] nums) {
            if (nums.length==1)return nums[0];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int temp:nums){
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else {
                    map.put(temp,1);
                }
            }
            for (int temp:nums){
                if (map.get(temp)==1)return temp;
            }
            return -1;
        }
    }

}
