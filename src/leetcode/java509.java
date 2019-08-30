package leetcode;

public class java509 {
  static   class Solution {
        public int fib(int N) {
            int temp;
            if(N==0){
                temp=0;
            }else if(N==1){
                temp=1;
            }else {
                temp= this.fib(N-1)+this.fib(N-2);
            }
        return temp;
        }

    }
    public static void main(String[] args){
      Solution solution =new Solution();
      System.out.println(solution.fib(2));
    }
}
