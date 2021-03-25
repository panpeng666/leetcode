package 剑指offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java09 {
    class CQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()){
                if (stack1.isEmpty()){
                    return -1;
                }else {
                    return stack1.pop();
                }
            }else {
                if (stack1.isEmpty()){
                    return -1;
                }else {
                    //此时需要删除stack2的尾巴，需要搞一个tempStack去存取stack2
                    while (!stack2.isEmpty()){
                        stack1.push(stack2.pop());
                    }
                    int temp = stack1.pop();
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                    return temp;
                }
            }

        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
