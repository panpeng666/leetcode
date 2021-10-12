package leetcode;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class java6 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *  
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public String convert(String s, int numRows) {
            //建一个二位数组，塞进去，再Stringbuilder 起来
            if (numRows==1)return s;
            char[][] tag = new char[numRows][s.length()];
            int i=0;
            int j=0;
            boolean flag = true;
            for (char temp:s.toCharArray()){
                //放z的头
                if (flag){
                    tag[i][j] =  temp;
                    i++;
                    //判断是否到最底层
                    if (i==numRows){
                        flag=false;
                        i--;
                        continue;
                    }
                }
                //开始放斜边
                else  {
                    i--;
                    j++;
                    tag[i][j]=temp;
                    if (i==0){
                        flag=true;
                        i++;
                        continue;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();

            for (int m=0;m<numRows;++m){
                System.out.println(Arrays.toString(tag[m]));
                for (int n=0;n<tag[m].length;++n){
                    if (tag[m][n]!=0){
                        sb.append((char) tag[m][n]);
                    }
                }
            }
            return sb.toString();
        }
        //用Stringbuilder
        public String convert1(String s, int numRows) {
            if (numRows<2)return s;
            List<StringBuilder> ans = new ArrayList<>();
            for (int i=0;i<numRows;i++){
                ans.add(new StringBuilder());
            }
            boolean flag = true;
            int n = 0;
            for (char temp:s.toCharArray()){
                if (flag){
                    ans.get(n).append(temp);
                    n++;
                    if (n==numRows){
                        flag=false;
                        n--;
                    }
                }else {
                    n--;
                    ans.get(n).append(temp);
                    if (n==0){
                        flag=true;
                        n++;
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder sb:ans){
                res.append(sb);
            }
            return res.toString();
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        System.out.println(solution.convert1("PAYPALISHIRING",2));;
    }
}
