package leetcode;

import java.util.Objects;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java463 {
    class Solution {
        public int islandPerimeter(int[][] grid) {
            if (Objects.isNull(grid)){return 0;}
            int a = grid.length;
            int b = grid[0].length;
            int res = 0;
            for (int i=0;i<a;i++){
                for (int j =0;j<b;j++){
                    if (grid[i][j]==1){
                        int temp = 0;
                        //判断这个数字上下左右是否是1，还得防止数组越界
                        //判断下边
                        if (i+1<=a-1&&grid[i+1][j]==0||i==a-1){
                            temp++;
                        }
                        if (i-1>=0&&grid[i-1][j]==0||i==0){
                            temp++;
                        }
                        if (j+1<=b-1&&grid[i][j+1]==0||j==b-1){
                            temp++;
                        }
                        if (j-1>=0&&grid[i][j-1]==0||j==0){
                            temp++;
                        }
                        res+=temp;
                        }
                    }
                }
            return res;
        }


            public int islandPerimeter1(int[][] grid) {
            if (Objects.isNull(grid)){return 0;}
                int a = grid.length;
                int b = grid[0].length;
                int res = 0;




                return res;
            }
    }
}
