package leetcode;

/**
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 *
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *  
 *
 * 提示：
 *
 * -104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java223 {
    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            //需要先判断是否有交集，再去计算面积
            int areaA = (ax2-ax1)*(ay2-ay1);
            int areaB = (bx2-bx1)*(by2-by1);
            int areaC = 0;
            //此时有重合区域，需要减去
            if (check(ax1,ax2,bx1,bx2)&&check(ay1,ay2,by1,by2)){

             int length = Math.min(ax2,bx2)-Math.max(ax1,bx1);
             int high = Math.min(ay2,by2)-Math.max(ay1,by1);
             areaC=length*high;
            }
            return areaA-areaC+areaB;

        }

        public boolean check(int a1,int a2,int b1,int b2){
            boolean flag = true;
            if (b1>a2||b2<a1){
                flag = false;
            }
            return flag;
        }

    }
}
