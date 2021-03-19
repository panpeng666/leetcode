package 剑指offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java05 {

    class Solution {
        public String replaceSpace(String s) {
          return   s.replaceAll(" ","%20");
        }



        public String replaceSpace1(String s) {
            StringBuilder sb = new StringBuilder();
            for (char a:s.toCharArray()){
                if (a==' '){
                    sb.append("%20");
                }else sb.append(a);
            }
            return sb.toString();
        }


}


}
