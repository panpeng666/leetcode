package leetcode;

import java.util.Arrays;

public class java4 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *  
     *
     * 提示：
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int [] nums3 = new int[m+n];
            if (m==0){
                nums3=nums2;
            }
            if (n==0){
                nums3=nums1;
            }
            //设定2个指针
            int a = 0;
            int b = 0;
            if (m!=0&&n!=0){
                for (int i=0;i<(m+n);++i){
                    if (a<m&&b<n){
                        if (nums1[a]<=nums2[b]){
                            nums3[i]=nums1[a];
                            ++a;
                        }else {
                            nums3[i]=nums2[b];
                            ++b;
                        }
                        continue;
                    }
                    if (a>=m){
                        nums3[i]=nums2[b];
                        ++b;
                        continue;
                    }
                    if (b>=n){
                        nums3[i]=nums1[a];
                        ++a;
                        continue;
                    }

                }
            }
            //除不尽，奇数
            System.out.println(Arrays.toString(nums3));
            if ((m+n)%2!=0){
                System.out.println("A");
                return new Double(nums3[((m+n)/2)+1]);
            }else {
                System.out.println("B");
                int i=nums3[(m+n)/2];
                int j = nums3[((m+n)/2)-1];
                if ((i+j)%2!=0){
                    return (i+j)/2 + 0.5;
                }
                return (nums3[(m+n)/2]+nums3[((m+n)/2)-1])/2;
            }
        }
    }
}
