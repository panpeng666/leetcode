package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java929 {
    static class Solution {
        public int numUniqueEmails(String[] emails) {
            HashSet <String> result = new HashSet<>();
            int len = emails.length;
            for (String temp: emails){
                char[] a = temp.toCharArray();
                int b= Arrays.binarySearch(a,'@');
                StringBuilder address = new StringBuilder();
                for(int i=0;i<b;i++){
                    if(a[i]=='.'){
                        continue;
                    }
                     else if (a[i]=='+'){
                        break;
                    }else {address.append(a[i]);}
                }
                for(int j=b;b<a.length;b++){
                    address.append(a[j]);
                }
                result.add(address.toString());
            }
            return result.size();
        }




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
}
