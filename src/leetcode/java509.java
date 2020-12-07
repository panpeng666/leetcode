package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java509 {
  static   class Solution {
      //最简单的递归，暴力解法
      public int fib(int N) {
            int temp;
            if(N==0){
                temp=0;
            }else if(N==1){
                temp=1;
            }else {
                temp= this.fib(N-1)+this.fib(N-2);
            }
        return temp;
        }
        //从下往上反计算，用一个数组保存数据
        public int fib1(int N) {
            if (N==0)return 0;
            int[] res =new int[N];
            res[0]=1;
            res[1]=1;
        for (int i =2;i<=N;i++){
            res[i]=res[i-2]+res[i-1];
        }
        return res[N];
        }

      public int fib2(int N) {
          if(N==1||N==2){return 1;}
          int i=1;
          int j=0;
          int res=0;
          for (int temp=2;temp<=N;temp++){
              res=i+j;
              j=i;
              i=res;
          }
          return res;
      }
    }
    public static void main(String[] args){
      Solution solution =new Solution();
      System.out.println(solution.fib(2));
    }
}
