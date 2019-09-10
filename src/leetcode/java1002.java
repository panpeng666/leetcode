package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/*想是走26个数字的计数排序的思路，但是这样如果有重复的值就很不好处理
   可以试试把最长的一个string提出来，然后对他进行计数count？

阅读其他人思路后，这题思路有点类似计数sort，但是解法是求各个string的交集

 */


public class java1002 {
    class Solution {
        public List<String> commonChars(String[] A) {
            List<String> list =new ArrayList<>();
            //新建一个数组存放各个char出现的次数
            int [] res=new int[26];
            //首先将第一个string进行计数然后放进去
            for (char temp:A[0].toCharArray()){
                res[temp-'a']++;
            }
            //再走一个循环，把和后面的交集放进去
            for (int i=1;i<A.length;i++){
                int [] tempRes = new int[26];
                for (char b:A[i].toCharArray()){
                    tempRes[b-'a']++;
                }

                for (int j=0;j<26;j++){
                        res[j]=Math.min(res[j],tempRes[j]);
                }
            }
            //这个时候res的值就造好了，然后转换为正确的结果再返回
            for (int n=0;n<res.length;n++){
                if (res[n]>0){
                    for (int l=0;l<res[n];l++){
                        list.add((char)(n+'a')+"");
                    }
                }
            }
            return list;
        }
    }
}
