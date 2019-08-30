package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
一个自划分数是一个数字，是由它所包含的每个数字整除。

例如，128是自分割数，因为128 % 1 == 0，128 % 2 == 0和128 % 8 == 0。

此外，不允许自分割数包含数字零。

给定数字的下限和上限，输出每个可能的自划分数的列表，如果可能，包括边界。

例1：
输入：
left = 1，right = 22
输出： [1,2,3,4,5,6,7,8,9,11,12,15,22]
注意：

每个输入参数的边界是1 <= left <= right <= 10000。
 */
public class java728 {
 static    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> res = new ArrayList<>();

        for (int i = left;i<=right;i++){
            if (i==0){i++;}
            boolean test=false;
//            System.out.println("i is "+i);
            String a= String.valueOf(i);
            for(int j=0;j<a.length();j++){
                int x=Integer.parseInt(String.valueOf(a.charAt(j)));
//                System.out.println("x is "+x);
                if(x==0){
//                    System.out.println("x is 0,无法除");
                    test=false;
                    break;
                }
                if (i%x==0){
                    test=true;
//                    System.out.println("i is "+i+" and x is "+x+"  true");
                    continue;
                }else {
                    test=false;
                    break;}
            }
            if(test){
//                System.out.println("we add i is "+i);
                res.add(i);}
        }
        return res;
        }
    }

    public static void main(String[] args) {
     Solution solution = new Solution();
     System.out.println(solution.selfDividingNumbers(1,22));
        }
 }
