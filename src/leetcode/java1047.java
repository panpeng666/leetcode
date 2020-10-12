package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *  
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//第一反应就是迭代（当然迭代性能弱得一比）
    //我错了，我不用自己的sb迭代了
public class java1047 {
    //先暴力解法，我lbw今天就是不用栈来做题
    static class Solution {
        public String removeDuplicates(String S) {
            if (S.length()==1){return S;}
            StringBuilder sb = new StringBuilder(S);
            while (true){
                boolean flag = true;
                for (int i=1;i<sb.length();i++){
                    if (sb.charAt(i)==sb.charAt(i-1)){
                        sb.replace(i-1,i+1,"");
                        flag=false;
                    }
                }
                if (flag){break;}
            }
            return sb.toString();
        }

        //用栈的思想来做题
        //这个是不用栈，用stringBuilders代替栈来实现

        public String removeDuplicates1(String S) {
            StringBuilder sb = new StringBuilder();
            int a=0;
            for (int i=0;i<S.length();i++){
                if (a!=0&&sb.charAt(a-1) == S.charAt(i)){
                    sb.deleteCharAt(--a);
                }else {
                    sb.append(S.charAt(i));
                    a++;
                }

            }

            return  (sb.toString());
        }

        //申明栈来实现
        public String removeDuplicates2(String S) {
            Stack<Character> stack = new Stack<>();

            for (int i=0;i<S.length();i++){

                if (!stack.isEmpty()&&stack.peek()==S.charAt(i)){
                    stack.pop();

                }else {
                    stack.push(S.charAt(i));
                }

            }
            StringBuilder sb = new StringBuilder();
            for (char temp:stack){
                sb.append(temp);
            }
            return sb.toString();
        }


        public static void main(String[] args) {
            Solution solution = new Solution();
           // System.out.println(solution.removeDuplicates("abbacaa"));
            System.out.println(solution.removeDuplicates2("abbacaa"));
        }
    }
}


