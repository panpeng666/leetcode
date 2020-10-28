package leetcode;

/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java1518 {
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            if (numBottles<numExchange){return numBottles;}
            boolean flag =true;
            int result =0;
            while (flag){
                int temp=numBottles/numExchange+numBottles%numExchange;
                if (temp<numExchange){
                    result+=temp;
                    flag=false;
                }
                result+=numBottles-numBottles%numExchange;
                numBottles=temp;
            }
            return result;
        }
    }


}
