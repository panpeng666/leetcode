package leetcode;
/**
 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

 示例 1:

 输入: S = "loveleetcode", C = 'e'
 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 说明:

 字符串 S 的长度范围为 [1, 10000]。
 C 是一个单字符，且保证是字符串 S 里的字符。
 S 和 C 中的所有字母均为小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java821 {
   static class Solution {
        public int[] shortestToChar(String S, char C) {
            int len =S.length();
            int[] res=new int[len];
            int[] temp=new int[len];
            //先找到字符串S中，C字符的位置，在数组中置0
            for (int i=0;i<len;i++){
                if (S.charAt(i)==C){
                    temp[i]=i;

                }else {res[i]=1;}
            }
            //看看数组下标？

            for (int j=0;j<len;j++){

                if (res[j]==1){
                    System.out.println("对第"+j+"个数字进行判断");
                    int temp1=len;
                    int temp2=len;
                    //右遍历找到第一个0
                    for (int l=j+1;l<len;l++){
                        if (res[l]==0){
                            temp1=l-j;
                            break;
                        }
                    }
                    for(int l=j-1;l>=0;l--){
                        System.out.println(j);
                        System.out.println(l);

                        if (res[l]==0){

                            temp2=j-l;
                            break;
                        }


                }
                    System.out.println("右遍历第一个0得位置是"+temp1+"左边遍历第一个0得位置是"+temp2);
                    res[j]=Math.min(temp1,temp2);
            }
            }


            for (int i:res){
                System.out.println(i);
            }


            return res;
        }
//双指针解法
       public int[] shortestToChar1(String s, char c) {
           int left = -1;
           int right = -1;
           int[] result = new int[s.length()];
           for (int i = 0; i < result.length; i++) {
               if(i>right){
                   for (int j=i;j<result.length;j++){
                       if(s.charAt(j)==c){
                           left = right;
                           right = j;
                           break;
                       }
                   }
               }
               if(left==-1){//这里等于考虑到自身就是目标数字的时候
                   result[i] = Math.abs(right-i);//求绝对值
               }else{
                   result[i] = Math.abs(Integer.min(right-i,i-left));
               }
           }
           for (int i:result){
               System.out.println(i);
           }
           return result;
       }

    }
    public static void main(String[] args){
        Solution solution=new Solution();
        String a="aaaa";
        char b='a';
        System.out.println(solution.shortestToChar(a,b));
    }
}
