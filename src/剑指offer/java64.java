package 剑指offer;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java64 {
    class Solution {
        //递归(要用if，不得行)
        public int sumNums(int n) {
            if(n==1)return 1;
            return n+sumNums(n-1);
        }
        //抛异常
        public int sumNums1(int n) {
            try {
               int temp= 1/n;
                return n+sumNums1(n-1);
            }catch (Exception e){
                return 1;
            }
        }
        //短路与
        int res = 0;
        public int sumNums2(int n) {
            boolean x = n>1&&(n+sumNums2(n-1))>0;
            res+=n;
            return res;
        }

    }
}
