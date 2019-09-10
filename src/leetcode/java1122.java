package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java1122 {


   static class Solution {
       public int[] relativeSortArray(int[] arr1, int[] arr2) {
           //创建一个1001长度的数组A存放arr1各个值得计数
            int [] A = new int[1001];
            //创建B数组，长度为和arr1一致，用于放置答案
            int [] B = new int[arr1.length];
            //将arr1数组得计数置入A数组中
            for (int i:arr1){
                A[i]++;
            }
            //这里开始构建答案，按照arr2的排序顺序，将arr1中的值置入B数组
           int cnt = 0;
           for(int i = 0; i < arr2.length; i++) {
               while(A[arr2[i]] > 0) {
                   B[cnt++] = arr2[i];
                   A[arr2[i]]--;
               }
           }
           //完成上述操作后，此时数组A中的值只有非arr2的数据，按顺序导入B数组即可
           for(int i = 0; i < 1001; i++) {
               while(A[i] > 0) {
                   B[cnt++] = i;
                   A[i]--;
               }
           }
           return B;
       }
        }
}
