package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java21 {
     static class Solution {
        public int[] exchange3(int[] nums) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int temp:nums){
                if (temp%2==0){
                    list2.add(temp);
                }else {
                    list1.add(temp);
                }
            }
            for (int i=0;i<list1.size();i++){
                nums[i]=list1.get(i);
            }
            for (int j=list1.size();j<(list1.size()+list2.size());j++){
                nums[j]=list2.get(j-list1.size());
            }
            return nums;
        }
    }
    //这题考的是指针，答案给了2种指针思路，首尾指针和快慢指针，抄答案思路做做
    public int[] exchange1(int[] nums) {
        int left=0;
        int right=nums.length;
        while (left<right){
            if (nums[left]%2==1){//说明是奇数
                left++;
                continue;
            }
            if (nums[right]%2==0){
                right--;
                continue;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        return nums;
    }
//快慢指针
    public int[] exchange(int[] nums) {
         if (Objects.isNull(nums))return null;
        if (nums.length==1){return nums;}
        int left=0;
        int right=0;
        while (right<nums.length){

            if (nums[right]%2==1){
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                right++;
                left++;
            }else {
                right++;
            }
        }
        return nums;
    }


}
