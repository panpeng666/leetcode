package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 *
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java475 {
    //目前思路是，头尾2个供暖器需要和头尾2个房屋位置单独处理，取其最大值
    //对heaters数组两两求差值，取最大值除2
    //以上2个数取最大值即为最小半径
    //此处做法需要考虑供暖器只有一台的情况，需要加入判断

    /*
    上诉思路还是基于房屋数组是连续的才行，如果不连续，比如house{11，19，49}  heaters{11，19，49}，此时答案应该是0才行，而走刚刚
    的思路，不会得出这种情况

    我觉得现在的解法思路应该是 house上每个数字和heaters最近的数求差值，然后取最大值，这样周全一些

    那么如何使用代码实现这个思路呢？
    先循环遍历 houses ，让每个heaters 去和单个houses位置进行求绝对值，然后取最小值，最后再取最大值


    噗，第一次提交，发现还有 house小于heaters的情况，真尼玛坑呀
    这种情况如何处理？



说白了这题还是考相对距离，只是我目前的解法没考虑到刚刚的情况，从新整理下思路
这题难点在于，house数组中每个值要与heaters中绝对值最近的数来求绝对值，

整理思路来，还是可以先遍历 houses ，让每个heaters 去和单个houses位置进行求绝对值，然后取最小值

     */

    static class Solution {
//        public int findRadius(int[] houses, int[] heaters) {
//            //头尾还是单独处理,取最大值
//            int result;
//            if(heaters.length>=houses.length) {
//                result = Math.max(Math.abs(houses[0] - heaters[0]), Math.abs(houses[houses.length - 1] - heaters[heaters.length - 1]));
//
//                //再循环遍历 houses ，让每个heaters 去和单个houses位置进行求绝对值，然后取最小值
//
//                //houses头尾不遍历
//                for(int i=1;i<(houses.length-2);i++){
//
//                    int temp1=Math.abs(houses[i]-heaters[1]);
//                    int temp2=Math.abs(houses[i]-heaters[1]);
//                    for (int j=1;j<(heaters.length-2);j++){
//                        temp2=Math.abs(heaters[j]-houses[i]);
//                        temp2=Math.min(temp1,temp2);
//                        temp1=temp2;
//                    }
//                    result=Math.max(result,temp2/2);
//                }
//            }else {
//                result=0;
//                //先遍历每个heaters，看最近的房子求绝对值，然后取最小值#滑稽
//                for (int i=0;i<heaters.length;i++){
//                    int temp1=Math.abs(houses[1]-heaters[i]);
//                    int temp2=Math.abs(houses[1]-heaters[i]);
//                    for (int j=0;j<houses.length;j++){
//                        temp2=Math.abs(heaters[j]-houses[i]);
//                        temp2=Math.min(temp1,temp2);
//                        temp1=temp2;
//                    }
//                    result=Math.max(result,temp2/2);
//                }
//            }
//            return result;
//        }
//    }

        //这种解法不是不行，只是在大量数据计算时会超时。。。
//    public int findRadius(int[] houses, int[] heaters) {
//            List<Integer> max = new ArrayList<>();
//        for (int i:houses){
//            List<Integer> arrayList = new ArrayList<>();
//            for (int j:heaters){
//                int temp = Math.abs(j-i);
//                arrayList.add(temp);
//            }
//            max.add(Collections.min(arrayList));
//        }
//
//        return Collections.max(max);
//    }

        //噗，还是不行，尼玛嗨，看官方答案去。。。。
        //噗，自己设计判断逻辑问题，这样解法是可以的，就是时间复杂度差不多上天了，空间复杂度倒是很小，这题居然熬了我好久
        //目前有几种减小时间复杂度的方法，比如 二分法，减少遍历次数，或者 贪心算法
        //一会列一下这2钟方法好了
            public int findRadius(int[] houses, int[] heaters) {
                Arrays.sort(heaters);
                Arrays.sort(houses);
                int max = -1;
                for (int i : houses) {
                    int min =Math.max( heaters[heaters.length - 1] - houses[0],houses[houses.length-1]-heaters[0]);
                    for (int j : heaters) {
                        min = Math.min(min, Math.abs(i - j));
//                        System.out.println("min"+min);
                    }
                    max = Math.max(max, min);
//                    System.out.println("max"+max);
                }
                return max;
            }
//二分法解法
        public int findRadius_1(int[] houses, int[] heaters) {
                //先排序
                 Arrays.sort(heaters);
                 Arrays.sort(houses);
                 int max=-1;
                 for(int i:houses){
                     //遍历house，然后二分法与heaters中的值对比，从而减少循环次数，降低时间复杂度
                     int min;
                     int left=0;
                     int right=heaters.length-1;
                    while (left<right){
                        System.out.println("left is"+left);
                        System.out.println("right is"+right);
                        int mid = (left+right)/2;
                        System.out.println("mid  is  "+mid);
                        if(heaters[mid]<i){
                            left=mid+1;
                        }else {right=mid;}
                    }

                    if (heaters[left]==i){
                        min=0;
                    }
                    else{
                        min=Math.abs(heaters[left]-i);
                    }
                    System.out.println("now min is"+min);
                    max=Math.max(max,min);
                 }
                 return max;
        }

//贪心策略
        public int findRadius_2(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);

            int j = 0;
            int max = -1;
            for(int i = 0;i < houses.length;i++){
                if((j + 1 < heaters.length) && (Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1]))){
                    j++;
                    i--;
                }else{
                    if(max < Math.abs(houses[i] - heaters[j])){
                        max = Math.abs(houses[i] - heaters[j]);
                    }
                }
            }
            return max;
        }



        public static void main(String[] arg) {
            Solution solution = new Solution();
            int[] houses = {1,2,3,4};
            int[] heaters = {1,4};
            System.out.println(1/2);
            System.out.println(solution.findRadius_1(houses, heaters));
        }
    }
}

