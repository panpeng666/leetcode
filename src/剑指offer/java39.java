package 剑指offer;

import java.util.HashMap;

public class java39 {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     *  
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        //这种方法不行，因为有负数存在
        public int majorityElement(int[] nums) {
            for (int i=0;i<nums.length;i++){
                int size=1;
                for (int j=i;j<nums.length;j++){
                    if (nums[i]==nums[j]){
                        size++;
                        if (size>nums.length/2){
                            return nums[i];
                        }
                    }
                }
            }
            return 0;
         }
         //hashmap的解法
        public int majorityElement1(int[] nums) {
            if (nums==null)return 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int temp:nums){
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else map.put(temp,1);
            }
            int max=0;
            for (int temp:nums){
                max=Math.max(map.get(temp),max);
            }
            for (int temp:nums){
                if (map.get(temp)==max){
                    return temp;
                }
            }
            return max;
        }
        //摩尔投票法
        public int majorityElement2(int[] nums) {
            if (nums==null)return 0;
            int temp=nums[0];
            int size=1;
            for (int i=1;i<nums.length;i++){
                if (size>0) {
                    if (nums[i] == temp) {
                        size++;
                    }else {
                        size--;
                    }
                }else {
                    temp=nums[i];
                    size=1;
                }
            }
            return temp;
        }
    }
}
