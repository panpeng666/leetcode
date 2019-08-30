package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String removeOuterParentheses(String S) {
        List<Integer> list= new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                list.add(i);
                for(int b=i+1;b<S.length();b++){
                    if (S.charAt(b)==')'){
                        list.add(b);
                        i=b;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<list.size();i++){
//            char a ='(';
//            result.append(S.charAt(i));
            result.append(S.charAt(list.get(i).intValue()));
        }
        return result.toString();
    }
   public static void main(String[] args){
        Solution solution=new Solution();
        String a="(()())(())(()(()))";
        System.out.print(solution.removeOuterParentheses(a));
   }
}