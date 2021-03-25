package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java57_错题 {
   static class Solution {
        //这是个数学题
         public int[][] findContinuousSequence(int target) {
            Queue<int[]> queue = new LinkedList<>();
            int i=2;
            while (i<target/2){
                int temp = target/i;
                int yushu = target%i;
                if (yushu==i-1&&yushu!=0){
                    int[] a = new int[i];
                    int z = i/2;
                    for (int j=0;j<i;j++){
                        a[j]=temp-z;
                        z++;
                    }
                    queue.add(a);
                }
                i++;
            }
            int[][] ans = new int[queue.size()][];
            for (int n=0;n<queue.size();n++){
                ans[n]=queue.poll();
            }
            return ans;
        }
    }

    /**
     * 抄答案：暴力滑动窗口，和我最开始思路很像
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        //🧠里要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
        //套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
        //当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
        for (int l = 1, r = 1, sum = 0; r < target; r++) {
            sum += r;
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findContinuousSequence(9);
    }
}
