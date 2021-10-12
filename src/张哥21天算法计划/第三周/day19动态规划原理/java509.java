package 张哥21天算法计划.第三周.day19动态规划原理;

import java.util.List;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *
 *
 * 提示：
 *
 * 0 <= n <= 30
 */
public class java509 {
    class Solution {
        //递归暴力解
        public int fib(int n) {
            if (n==0)return 0;
            if (n==1)return 1;
            return fib(n-1)+fib(n-2);
        }
        //自下而上的迭代
        public int fib1(int n){
            if (n==0)return 0;
            if (n==1)return 1;
            int temp0 = 0;
            int temp1 = 1;
            int i=0;
            while (i<=n){
                int temp=0;
                temp=temp0+temp1;
                temp0=temp1;
                temp1=temp;
                i++;
            }
            return temp1;
        }
        //创建一个数组保存结果
        public int fib2(int n){
            if (n==0)return 0;
            if (n==1)return 1;
            int[] lists = new int[n+1];
            lists[0]=0;
            lists[1]=1;
            for (int i=2;i<=n;++i){
                lists[i]=lists[i-1]+lists[i-2];
            }
            return lists[n];
        }
        //简化保存结果的table
        public int fib3(int n){
            if (n==0)return 0;
            if (n==1)return 1;
            int[] lists = new int[2];
            lists[0]=0;
            lists[1]=1;

            while (n>1){
                int temp=lists[0]+lists[1];
                lists[0]=lists[1];
                lists[1]=temp;
                n--;
            }
            return lists[1];
        }
    }
}
