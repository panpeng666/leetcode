package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 *  输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java17 {
    static class Solution {
        //需要把n转换为位数，然后创建一个数据，把值置入
        public int[] printNumbers(int n) {
            int i = 1;
            int length=0;
            while (n>0){
                length=length+9*i;
                i=10*i;
                n--;
            }
            int[] a = new int[length];
            for (int j=1;j<=length;j++){
                a[j-1]=j;
            }
            return a;
        }

        //需要考虑大数导致int溢出的情况，返回值改为string[]
        public String[] printNumbers1(int n) {
            String[] a =  {"0","1","2","3","4","5","6","7","8","9"};
            StringBuilder temp = new StringBuilder();
            while (n>0){

                n--;
            }
            return a;
        }


        //官方答案
        StringBuilder res;
        int count = 0, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public String printNumbers3(int n) {
            this.n = n;
            res = new StringBuilder(); // 数字字符串集
            num = new char[n]; // 定义长度为 n 的字符列表
            dfs(0); // 开启全排列递归
            res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
            return res.toString(); // 转化为字符串并返回
        }
        void dfs(int x) {
            if(x == n) { // 终止条件：已固定完所有位
                res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
                return;
            }
            for(char i : loop) { // 遍历 ‘0‘ - ’9‘
                num[x] = i; // 固定第 x 位为 i
                dfs(x + 1); // 开启固定第 x + 1 位
            }
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.printNumbers(7));
    }
}
