package 剑指offer;

import java.util.Stack;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java58_1 {
        public String reverseWords(String s) {
            Stack<String>  stack = new Stack<>();
            if (s.length()==0)return s;
            StringBuilder sb = new StringBuilder();
            for (char temp:s.toCharArray()){
                if (temp==' '){
                    if (sb.length()==0){
                        continue;
                    }else {
                        stack.push(sb.toString());
                        sb.delete(0,sb.length());
                    }
                }else {
                    sb.append(temp);
                }
            }
            if (sb.length()!=0){stack.push(sb.toString());}
            if (stack.isEmpty())return s;
            sb.delete(0,sb.length());
            while (!stack.isEmpty()){
                sb.append(stack.pop());
                sb.append(' ');
            }
            sb.delete(sb.length()-1,sb.length());
            return sb.toString();
        }



    public static void main(String[] args) {
        java58_1 java58_1 = new java58_1();
        System.out.println(java58_1.reverseWords("is blue"));
    }
}
