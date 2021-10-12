package 张哥21天算法计划.第三周.day19动态规划原理;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java322 {
    class Solution {
        int [] nums;
        //备忘录法，自上而下
        public int coinChange(int[] coins, int amount) {
            nums = new int[amount+1];
            Arrays.fill(nums,-666);
            return dp(coins,amount);
        }
        public int dp(int[] coins, int amount) {
            if (amount==0)return 0;
            if (amount<0)return -1;
            int res = Integer.MAX_VALUE;
            if (nums[amount]!=-666)return nums[amount];
            for (int coin:coins){
                int temp = dp(coins,amount-coin);
                if (temp==-1) continue;
                res=Math.min(res,temp+1);
            }
            res = (res == Integer.MAX_VALUE?-1 :res);
            nums[amount]=res;
            return res ;
        }
        //dp数组自下而上
        int[] dp;
        public int coinChange1(int[] coins, int amount) {
            dp = new int[amount+1];
            Arrays.fill(dp,amount+1);
            if (amount==0)return 0;
            if (amount<0)return -1;
            dp[0]=0;
            for (int n=0;n<dp.length;n++){
                for (int coin:coins){
                    if (n-coin<0){
                        continue;
                    }
                    dp[n]=Math.min(dp[n],dp[n-coin]+1);

                }

            }

            return (dp[amount] == amount+1)?-1 :dp[amount];
        }
    }
}
