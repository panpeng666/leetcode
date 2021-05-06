package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;

public class java50 {
    class Solution {
        public char firstUniqChar(String s) {
            int[] temp = new int[26];
            for (char a:s.toCharArray()){
                temp[a-97]++;
            }
            for (int i=0;i<26;i++){
                if (temp[i]==1){
                    return (char)(i+97);
                }
            }
            return ' ';
        }
        //需要第一次才行
        public char firstUniqChar1(String s) {
            //2次遍历，通过hashmap搞
            HashMap<Character,Integer> map = new HashMap<>();
            for (char temp:s.toCharArray()){
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else {
                    map.put(temp,1);
                }
            }
            for (char temp:s.toCharArray()){
                if (map.get(temp)==1){
                    return temp;
                }
            }
            return ' ';
        }
    }

}
