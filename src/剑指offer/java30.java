package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class java30 {
    class MinStack {
        List<Integer> list = new ArrayList<>();

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            if (Objects.isNull(list))return ;
            list.remove(list.size()-1);
        }

        public int top() {
            if (Objects.isNull(list))return Integer.parseInt(null);
            return list.get(list.size()-1);
        }

        public int min() {
            if (Objects.isNull(list))return Integer.parseInt(null);
            int a = list.get(0);
            for (int temp:list){
                a=Math.min(temp,a);
            }
            return a;
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
}
