package leetcode;

/**
 *
 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



 示例:

 现有矩阵 matrix 如下：

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 给定 target = 5，返回 true。

 给定 target = 20，返回 false。



 限制：

 0 <= n <= 1000

 0 <= m <= 1000
 */
public class java04 {
    class Solution {
        //问就是二分法

        public boolean findNumberIn2DArray(int[][] matrix, int target) {
          //桶排序
            for (int i=0;i<matrix.length;i++){
                for (int j=0;j<matrix[i].length;j++){
                    if (matrix[i][j]==target)return true;
                    if (matrix[i][j]>target)break;
                }
            }
            return false;
        }
        public boolean search(int[][] matrix, int target){
            int right = matrix.length-1;
            int left =0;
            int mid = 0;
            while (left<=right){
                 mid = ((right-left)+left)/2;
                if (matrix[mid][0]>target){
                    left=mid;
                }else {
                    right=mid;
                }
                if (matrix[mid][0] <= target&&target <= matrix[mid+1][0]) {
                    break;
                }
            }
           return search(matrix[mid],target);
        }
        public boolean search(int[] temp,int target){

            for (int i=0;i<temp.length;i++){
                if (temp[i]==target)return true;
            }
            return false;
        }
    }
}
