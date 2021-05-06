package 剑指offer;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 *
 * 限制：
 *
 * 数组长度为 5 
 *
 * 数组的数取值为 [0, 13] .
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java61 {
    class Solution {
        public boolean isStraight(int[] nums) {
            //没有大王
            boolean ans  =true;
            if(nums[0]!=0){
                for (int i=0;i<4;i++){
                    if (nums[i+1]-nums[i]!=1){
                        return false;
                    }
                }

            }else if (nums[1]!=0){//只有一张
                int count=1;
                for (int i=0;i<4;i++){
                    if (nums[i+1]-nums[i]!=1){
                        if (nums[i+1]-nums[i]==2){
                            if (count!=0){
                            count--;
                            continue;}else return false;
                        }else return false;
                    }
                }
            }else {//大小王都有
                int count=2;
                for (int i=0;i<4;i++){
                    if (nums[i+1]-nums[i]!=1){
                        if (nums[i+1]-nums[i]!=3){

                            count--;
                            count--;
                        }
                    }
                }
            }
            return true;
        }
    }
}
