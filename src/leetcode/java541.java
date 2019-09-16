package leetcode;

/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java541 {



   static class Solution {


        public String reverseStr(String s, int k) {
            StringBuilder res = new StringBuilder();
            int len = s.length();
            int remainder = len%(k*2);
            int count = len/(k*2);
            //这里的for循环处理前面每个2k字段
            for(int i=0;i<count;i++){
                StringBuffer temp = new StringBuffer(s.substring(i*2*k,(i+1)*2*k));
                System.out.println(temp);
                int a = temp.length();
                StringBuffer temp1=new StringBuffer(temp.substring(0,a/2));
                StringBuffer temp2=new StringBuffer(temp.substring(a/2,a));
                System.out.println(temp1);
                System.out.println(temp2);
                res.append(temp1.reverse());
                res.append(temp2);
                System.out.println(res);
            }

            //先依据s和k得对比，判断最后的字符串走哪一种转换方式
            if(remainder<k){
                StringBuffer temp3=new StringBuffer(s.substring(count*2*k,s.length()));
                res.append(temp3.reverse());
            }
            else if (remainder>=k){
                StringBuffer temp4=new StringBuffer(s.substring(count*2*k,count*2*k+k));
                StringBuffer temp5=new StringBuffer(s.substring(count*2*k+k,len));
                res.append(temp4.reverse());
                res.append(temp5);
            }
            return res.toString();
        }
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        String a ="abcdefgh";
        System.out.println(solution.reverseStr(a,2));
    }
}
