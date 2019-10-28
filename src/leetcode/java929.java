package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 *
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 *
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 *
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 *
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 *
 * 可以同时使用这两个规则。
 *
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 *
 *  
 *
 * 示例：
 *
 * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 *  
 *
 * 提示：
 *
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-email-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//10.25重做
    //需要拆分@前后文，先对前文遍历找+字符，然后对+前面去.，再和后文拼一起，放入HashSet
    //这种类型题目还是会考察一下你对string的方法的了解，毕竟你不知道就只能用一些笨方法解题
public class java929 {
    static class Solution {
        public int numUniqueEmails(String[] emails) {
            HashSet<String> result = new HashSet<>();
            for (String email:emails){
                 int a=email.indexOf('@');
                 String text=email.substring(0,a);//.replaceAll(".","");
                 String other=email.substring(a,email.length());
             //   System.out.println(text);

                StringBuilder texts= new StringBuilder();
                 for (int i=0;i<text.length();i++){
                     if (text.charAt(i)=='.'){
                         continue;
                     }
                   else if (text.charAt(i)=='+'){
                        break;
                    }else {
                       texts.append(text.charAt(i));
                       continue;
                     }
                 }
              //   System.out.println(texts);
                 String res=texts.toString()+other;
                 System.out.println(res);
                 result.add(res);
                }
            return result.size();
        }
//            for (String temp: emails){
//                char[] a = temp.toCharArray();
//                int b= Arrays.binarySearch(a,'@');
//                StringBuilder address = new StringBuilder();
//                for(int i=0;i<b;i++){
//                    if(a[i]=='.'){
//                        continue;
//                    }
//                     else if (a[i]=='+'){
//                        break;
//                    }else {address.append(a[i]);}
//                }
//                for(int j=b;b<a.length;b++){
//                    address.append(a[j]);
//                }
//                result.add(address.toString());
//            }
//            return result.size();





        public int numUniqueEmails1(String[] emails) {
            if(emails.length < 1) return 0;

            Set<String> set = new HashSet<>();
            for(String str : emails){
                String[] strs = str.split("@");
                String sb = strs[0];
                String temp ="";
                for(int i = 0;i < sb.length(); i++){
                    if(sb.charAt(i) == '.') continue;
                    else if(sb.charAt(i) == '+') break;
                    else temp += sb.charAt(i);
                }
//                temp += "@"+strs[1];
                set.add(temp);
            }
            return set.size();
        }

        public int numUniqueEmails3(String[] emails) {
            Set<String> result = new HashSet();
            for(String email:emails){
                int a = email.indexOf('@');
                String local = email.substring(0,a);
                String  rest = email.substring(a);

                if(local.contains("+")){
                   local=local.substring(0,local.indexOf('+'));
                }

                local.replaceAll(".","");
                result.add(local + rest);
            }
                return result.size();
        }
}

public static void main(String[] args){
        Solution solution=new Solution();
        String[] emails={"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com","fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com","fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com","fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com","r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com","r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com","r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com","fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"};
        System.out.println(solution.numUniqueEmails(emails));

}

}
