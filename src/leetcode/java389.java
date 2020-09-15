package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java389 {
    class Solution {
        public char findTheDifference(String s, String t) {
            char res= 'a';
            Map map = new HashMap();
            for (char temp :t.toCharArray()){
                if (map.containsKey(temp)){
                    map.put(temp,(int)map.get(temp)+1);
                }else {
                    map.put(temp,1);
                }
            }
            for (char temp :s.toCharArray()){
                if (map.containsKey(temp)){
                    if ((int)map.get(temp)-1 == 0){
                        map.remove(temp);
                    }else {
                    map.put(temp,(int)map.get(temp)-1);
                    }
                }
            }
            for (Object temp:map.keySet()){
                res=(char)temp;
            }
            return res;
        }
    }
}
