package leetcode;

import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java42 {
   static class Solution {
        /**
         * 暴力解法，对每个数字寻找左右两边的最大值，这一格可以接的雨水为左右最大值最低的一边减去当前的高度
         * 依次计算累加即可
         *复杂性分析
         *
         * 时间复杂度： O(n^2)。数组中的每个元素都需要向左向右扫描。
         *
         * 空间复杂度 O(1) 的额外空间。
         * @param height
         * @return
         */

        public int trap1(int[] height) {
            int answer=0;
            // 遍历数组
            for (int a=0;a<=height.length-1;a++){
                int leftMax=0;
                int rightMax=0;
                //找寻左边最大值
                for (int left=a;left>=0;left--){
                        leftMax=Math.max(height[left],leftMax);
                }
                //找寻右边最大值
                for(int right=a;right<=height.length-1;right++){
                        rightMax=Math.max(rightMax,height[right]);
                }
                int temp=Math.min(leftMax,rightMax)-height[a];
                if (temp>0){
                    answer+=temp;
                }
            }
            return answer;
        }

       /**
        * 动态编程
        * 思路：
        * 1，创建2个size为height.length的数组
        * 2，先从数组左到右遍历，把每个下标对应的右边最大值放进去
        * 3，再从数组右边到左遍历，把每个下标对应的左边边最大值放进去
        * 4，遍历整个数组，每个下标存储的雨水为 min（left，right）-height【i】
        * @param height
        * @return
        */


       public int trap2(int[] height) {
           int answer=0;
           //先处理特殊情况，如果height是null或者size只有1，2，return 0
           if(height == null ||height.length==0||height.length==1|height.length==2){
               return answer;
           }
           int [] left = new int[height.length];
           int [] right = new int[height.length];
           int leftMax=height[0];
           int rightMax=height[height.length-1];

           //左到右边进行遍历
           for (int l=0;l<=height.length-1;l++){
               left[l]=Math.max(leftMax,height[l]);
               leftMax=left[l];
           }
           //右到左遍历
            for (int r=height.length-1;r>=0;r--){
                right[r]=Math.max(rightMax,height[r]);
                rightMax=right[r];
            }
            for (int i=0;i<height.length;i++){
                int temp=Math.min(right[i],left[i])-height[i];
                    answer+=temp;

            }
           return answer;
       }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
