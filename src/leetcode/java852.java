package leetcode;
/**
 *  如果以下属性成立，我们将数组A称为山峰：
 *
 * A.length >= 3
 * 存在一些0 < i < A.length - 1这样的A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 鉴于一个绝对是一座山的阵列，返回任何  i 这样的  A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]。
 *
 * 例1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 例2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 * 注意：
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A是一座山，如上所述。
 */
public class java852 {

    class Solution {
        public int peakIndexInMountainArray(int[] A) {
            int temp=0 ;
            for(int i=1;i<A.length;i++){
                temp=A[i];
                if(temp>A[i+1]&&temp>A[i-1]){
                    temp=i;
                    break;
                }

            }
            return A[temp];
        }
    }
}
