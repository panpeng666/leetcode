package leetcode;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java171 {

    /*
        其实还是考察进制的理解，相当于是一个26进制的东西，前面考虑太简单了
        噗，我进制学的太差了
        进制应该这样做，从右往左，第一位是乘以26^0，第二位乘26^(1),第n位乘26^(n-1)，然后相加即可
     */
   static class Solution {
        public int titleToNumber(String s) {
            int len=s.length();
            int x=26;
            int res =0;
//            int len = 10*(s.length()-1);
            int y=0;
            for(int i=len-1;i>=0;i--) {
                double temp=Math.pow(x,y);//pow返回的是double值，好蠢
                int a=(int)temp;
                int b=s.charAt(i)-64;
                res=res+b*a;
                y++;
                System.out.println(a);
            }
            return res;
        }
        }

    public static void main(String[] args){
       Solution solution =new Solution();
       System.out.println(solution.titleToNumber("ABC"));
    }
}
