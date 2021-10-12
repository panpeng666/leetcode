package 剑指offer;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java12 {
    class Solution {
        /**思路整理
         *首先先找到首字母，然后广度搜索首字母上下左右是否有下一个字母，没有返回false
         * 先整理出伪代码，然后补充
         * 更正：其实dfs就可以去找到首字符了，因为会出现多个字符存在的情况，而且不能重复利用
         * 需要把正确的路径重置一下
         */
        public boolean exist(char[][] board, String word) {
            int length = board[0].length;
            int high = board.length;
            if (length*high<word.length())return false;
            int[] address = findFirst(board,word.charAt(0));
            if (address[0]==-1)return false;

            int i = 1;
            while (i<word.length()){
                address=isNextExist(board,address,word.charAt(i));
                if (address[0]==-1)return false;
                i++;
            }
            return true;
        }

        public int[] findFirst(char[][] board,char first){
            //记录首字母位置,需要注意找不到a的情况
            int[] a = new int[2];
            a[0]=-1;
            a[1]=-1;
            for (int i=0;i<board.length;i++){
                for (int j=0;j<board[i].length;j++){
                    if (board[i][j]==first){
                        a[0]=i;
                        a[1]=j;
                        return a;
                    }
                }
            }
            return a;
        }
        public int[] isNextExist(char[][]board,int[] address,char next){
            int high = board.length;
            int length = board[0].length;
            int i = address[0];//对应high
            int j = address[1];//对应high
            //上下左右分别为  (i-1，j)(i+1,j)(i,j-1)(i,j+1)
            //正常情况
           if (i-1>=0){
               if (board[i-1][j]==next){
                   address[0]=i-1;
                   return address;
               }
           }
           if (i+1<=high){
               if (board[i+1][j]==next){
                   address[0]=i+1;
                   return address;
               }
           }
           if (j+1<=length){
               if (board[i][j+1]==next){
                   address[1]=j+1;
                   return address;
               }
           }
            if (j-1>=0){
                if (board[i][j-1]==next){
                    address[1]=j-1;
                    return address;
                }
            }
            address[0]=-1;
            address[1]=-1;
        return address;

        }

        public boolean exist1(char[][] board, String word) {
            for (int i=0;i<board.length;i++){
                for (int j=0;j<board[i].length;j++){
                 boolean  flag= dfs(board,word.toCharArray(),i,j,0);
                    if (flag)return true;
                }
            }
            return false;
        }
        public boolean dfs(char[][] board,char[] s,int i,int j ,int nums){

            if(i >= board.length || i < 0 || j >= board[0].length || j < 0 ||  board[i][j]!=s[nums]) return false;

            if (nums==s.length-1)return true;
            board[i][j]='\0';
            boolean res = dfs(board,s,i+1,j,nums+1)||dfs(board,s,i-1,j,nums+1)||
                    dfs(board,s,i,j+1,nums+1)||dfs(board,s,i,j-1,nums+1);
            board[i][j]=s[nums];
            return res;

        }

    }
}
