package leetcode;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *  
 *
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 1000
 * S 只包含字符 "I" 或 "D"。

 */
public class java942 {

   static class Solution {
        public int[] diStringMatch(String S) {
            int len=S.length();
            int max=S.length();
            int min=0;
            int[] result= new int[max+1];
            for(int i=0;i<len;i++) {

                char Dchars = S.charAt(i);
                if (Dchars == 'D') {
                    result[i] = max;
                    System.out.println("第"+i+"位赋值"+max);
                    max--;
                }
                if (Dchars == 'I') {
                    result[i] = min;
                    System.out.println("第"+i+"位赋值"+min);
                    min++;
                }

            }
            result[len]=min;
            System.out.println("第"+len+"位赋值"+min);

                return result;
            }


        public   static void main(String[] args){
            Solution solution = new Solution();
            String a= "DDDDIII";
            System.out.println(Arrays.toString(solution.diStringMatch(a)));
            }

        }
    }

