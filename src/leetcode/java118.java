package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
 输出:
 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 **/
public class java118 {

    //第一次解题的方法很蠢，判断太多了
    class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (numRows==0){
            //   list.add(null);
            return list;
        }

        for (int i=1;i<=numRows;i++) {
            List<Integer> temp = new LinkedList<>();
            if (i==1){
                temp.add(1);
                list.add(temp);
            }
            if (i==2){
                temp.add(1);
                temp.add(1);
                list.add(temp);
            }
            else {
                temp=list.get(i-1);
                List<Integer> temp1 = new LinkedList<>();
                temp1.add(1);
                for(int j=0;j<(i-2);j++){
                    temp1.add(temp.get(j)+temp.get(j+1));
                }
                temp1.add(1);
                list.add(temp1);
            }


        }

        if (numRows==1){
            list.remove(1);}

        if (numRows>=2){
            list.remove(2);}
        return list;
    }

        //官方解法,大体思路差不多，无非判断比我简洁#滑稽
        public List<List<Integer>> generate1(int numRows) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();

            // First base case; if user requests zero rows, they get zero rows.
            if (numRows == 0) {
                return triangle;
            }

            // Second base case; first row is always [1].
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            for (int rowNum = 1; rowNum < numRows; rowNum++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(rowNum-1);

                // The first row element is always 1.
                row.add(1);

                // Each triangle element (other than the first and last of each row)
                // is equal to the sum of the elements above-and-to-the-left and
                // above-and-to-the-right.
                for (int j = 1; j < rowNum; j++) {
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }

                // The last row element is always 1.
                row.add(1);

                triangle.add(row);
            }

            return triangle;
        }

}




}
