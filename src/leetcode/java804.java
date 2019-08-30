package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class java804 {
   static class Solution1 {
        public int uniqueMorseRepresentations(String[] words) {
            StringBuilder res = new StringBuilder();
            Set<String>set=new HashSet<>();
            String[] list={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            for(int i=0;i<words.length;i++){
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
    }
    public static void main(String[] args){
        Solution1 solution=new Solution1();
        String[] a={"gin", "zen", "gig", "msg"};
        System.out.print(solution.uniqueMorseRepresentations(a));
    }
}
