package leetcode;

/*
There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.

Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

Example 1:

Input: "UD"
Output: true
Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.


Example 2:

Input: "LL"
Output: false
Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
在2D平面上有一个从位置（0,0）开始的机器人。给定其移动序列，判断该机器人在完成移动后是否在（0,0）处结束。

移动序列由字符串表示，字符move [i]表示其第i个移动。有效移动是R（右），L（左），U（上）和D（下）。如果机器人在完成所有移动后返回原点，则返回true。否则，返回false。

注意：机器人“面对”的方式无关紧要。“R”将始终使机器人向右移动一次，“L”将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。

例1：

输入： “UD”
 输出： true
 说明：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终会在它开始的原点处。因此，我们回归真实。


例2：

输入： “LL”
 输出： false
 说明：机器人向左移动两次。它最终在原点的左边有两个“移动”。我们返回false，因为它在移动结束时不在原点。
 */
public class java657 {
  static   class Solution {
        public boolean judgeCircle(String moves) {
            int U=0;
            int D=0;
            int R=0;
            int L=0;
            boolean res=false;
            for(int i=0;i<moves.length();i++){
                switch (moves.charAt(i)){
                    case'U':
                        U++;
                        break;
                    case'D':
                        D++;
                        break;
                    case'R':
                        R++;
                        break;
                    case'L':
                        L++;
                        break;
                }
            }
            if (U==D&&R==L){
                res=true;
            }
//            System.out.println(U);
//            System.out.println(D);
//            System.out.println(R);
//            System.out.println(L);
            return res;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("UD"));
    }
}
