package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class java06 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     *
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * Definition for singly-linked list.
     * */
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {
        public int[] reversePrint(ListNode head) {
            if (head==null)return null;
            Stack<Integer> stack = new Stack<>();
            while (head!=null){
                stack.push(head.val);
                head=head.next;
            }
            int [] ans = new int[stack.size()];
            int temp=0;
            while (!stack.isEmpty()){
                ans[temp]=stack.pop();
                temp++;
            }
            return ans;
        }

        public int[] reversePrint1(ListNode head) {
            List<Integer> temp = new ArrayList<Integer>();
            while (head!=null){
                temp.add(head.val);
                head=head.next;
            }
            int [] a =new int[temp.size()];
            Collections.reverse(temp);
            for (int i=0;i<temp.size();i++){
                a[i]=temp.get(i);
            }
            return a;
        }

    }
}
