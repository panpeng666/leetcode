package leetcode;

import java.util.HashMap;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java961 {

    class Solution {
        public int repeatedNTimes(int[] A) {
            int res=0;
            for(int i=0;i<A.length;i++){
                for (int j=i+1;j<A.length;j++){
                    if(A[i]==A[j]){
                        res= A[i];
                        break;
                    }
                }

            }
            return res;
        }
        public int repeatedNTimes1(int[] A) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int temp:A){
                if (map.containsKey(temp)){
                    if (map.get(temp)+1==A.length/2){
                        return temp;
                    }
                    map.put(temp,map.get(temp)+1);
                }else {
                    map.put(temp,1);
                }
            }
            return 0;
        }
    }

}
