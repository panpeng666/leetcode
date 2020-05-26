package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 *  
 *
 * 注意:
 *
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-morse-code-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class java804 {
   static class Solution1 {

       /**
        * 执行用时 :
        * 13 ms
        * , 在所有 Java 提交中击败了
        * 5.00%
        * 的用户
        * 内存消耗 :
        * 38.2 MB
        * , 在所有 Java 提交中击败了
        * 12.50%
        * 的用户
        */
        public int uniqueMorseRepresentations(String[] words) {

            Set<String>set=new HashSet<>();
            String[] list={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            for(int i=0;i<words.length;i++){
                StringBuilder res = new StringBuilder();
                for(int j=0;j<words[i].length();j++){
                   res.append(list[words[i].charAt(j)-97]);
                }
                System.out.println(res);
                set.add(res.toString());
                res.delete(0,res.length());
            }
            int k=1;
            int j=~k;
            System.out.println(j);
            return set.size();

        }
//       public int uniqueMorseRepresentations1(String[] words) {
//           String[] list={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
//
//
//
//       }
    }




    public static void main(String[] args){
        Solution1 solution=new Solution1();
        String[] a={"gin", "zen", "gig", "msg"};
        System.out.print(solution.uniqueMorseRepresentations(a));
    }
}
