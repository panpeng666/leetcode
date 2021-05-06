package 剑指offer;

import java.util.HashSet;
import java.util.Stack;

public class java52 {
    //Definition for singly-linked list.

     public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
     val = x;
     next = null;
          }
     }

    public class Solution {
         //第一想法就是入栈对比
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Stack<ListNode> stackA = new Stack<>();
            Stack<ListNode> stackB = new Stack<>();
            ListNode temp1 = headA;
            ListNode temp2 = headB;
            while (temp1!=null){
                stackA.push(temp1);
                temp1=temp1.next;
            }
            while (temp2!=null){
                stackB.push(temp2);
                temp2=temp2.next;
            }
            ListNode temp=null;
            while (!stackA.isEmpty()&&!stackB.isEmpty()){
                    ListNode temp3 = stackA.peek();
                if (stackA.pop()!=stackB.pop()){
                    return temp;
                }else {
                    temp=temp3;
                }
            }
            return temp;
        }
        //用栈太复杂，可以用hashset方便一丢

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            ListNode temp=headA;
            while (temp!=null){
                set.add(temp);
                temp=temp.next;
            }
            temp=headB;
            while (temp!=null){
                if (set.contains(temp))return temp;
                temp=temp.next;
            }
            return null;
        }
        //双指针
        public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
            ListNode temp1 = headA;
            ListNode temp2 = headB;
            int step=0;
            boolean flag1 = true;
            boolean flag2 = true;
            while (temp1!=temp2||(flag1&&flag2)){
                temp1=temp1.next;
                temp2=temp2.next;
                if (temp1==null){
                    temp1=headB;
                    flag1=false;
                }
                if (temp2==null){
                    temp2=headA;
                    flag2=false;
                }
            }
            return temp1;

        }
        }
}
