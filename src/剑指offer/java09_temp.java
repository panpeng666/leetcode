package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class java09_temp {
    class MinStack {
        List<Integer> list = new ArrayList();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            list.remove(list.size()-1);
         }

        public int top() {
            return list.get(0);
        }

        public int min() {
            int min = list.get(0);
            for (int temp:list){
                if (min>=temp){
                    min=temp;
                }
            }
            return min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    class CQueue {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if (stack2.size()<1)return -1;
            int temp = stack2.pop();

            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return temp;
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
