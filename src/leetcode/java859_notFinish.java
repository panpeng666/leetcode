package leetcode;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java859_notFinish {
//    class Solution {
//        public boolean buddyStrings(String A, String B) {
//            /*
//            满足亲密字符串的条件如下 1.字符长度相同 2.各个char的数量相等 3.A[i]=B[j],A[j]=B[i] ,且只有一个（既是调换一次）
//            我们可以走以上3个条件来写判断逻辑
//             */
//            //条件1
//            if(A.length()!=B.length())return false;
//
//            //条件2
//            int[] temp=new int[26];
//            for (char i:A.toCharArray()){
//                temp[i-'a']++;
//            }
//            for (char j:B.toCharArray()){
//                temp[j-'a']--;
//            }
//            for (int a:temp){
//                if (a!=0)return false;
//            }
//            //条件3
//
//        }
//    }
    class Solution1 {
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) return false;
            if (A.equals(B)) {
                int[] count = new int[26];
                for (int i = 0; i < A.length(); ++i)
                    count[A.charAt(i) - 'a']++;

                for (int c: count)
                    if (c > 1) return true;
                return false;
            } else {
                int first = -1, second = -1;
                for (int i = 0; i < A.length(); ++i) {
                    if (A.charAt(i) != B.charAt(i)) {
                        if (first == -1)
                            first = i;
                        else if (second == -1)
                            second = i;
                        else
                            return false;
                    }
                }

                return (second != -1 && A.charAt(first) == B.charAt(second) &&
                        A.charAt(second) == B.charAt(first));
            }
        }
    }

}
