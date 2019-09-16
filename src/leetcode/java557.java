package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java557 {
   static class Solution {
        public String reverseWords(String s) {
            StringBuilder res = new StringBuilder();
            List<Integer> temp = new ArrayList<>();
            //摸出来每个空格得位置放在数组temp中
            temp.add(0);
            for(int i=0;i<s.length();i++){
                if (s.charAt(i)==' '){
                    temp.add(i);
                }
            }
            temp.add(s.length());
            //构造答案
            for(int j=1;j<temp.size();j++){
                String a = s.substring(temp.get(j-1),temp.get(j));
                //System.out.println(a);
                a=new StringBuffer(a).reverse().toString();
                res.append(a);
                if(j==1){res.append(" ");}
            }
            res.deleteCharAt(res.length()-1);
            return res.toString();
        }

    }

    public static void main(String[] args){
       Solution solution=new Solution();
       System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
