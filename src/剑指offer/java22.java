package 剑指offer;

import java.util.Stack;

public class java22 {
    /**
     * Definition for singly-linked list.
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
         //方法1，先求出链表长度，2次循环裁剪
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head==null)return null;
            int length = 1;
            ListNode temp = head;
            while (temp.next!=null){
                temp=temp.next;
                length++;
            }
            int a = length-k;
            temp=head;
            while (a>0){
                temp=temp.next;
                a--;
            }
            return temp;
        }
        //双指针
        public ListNode getKthFromEnd1(ListNode head, int k) {
            if (head==null)return null;
            int a=0;
            int b=0;
            ListNode temp = head;
            ListNode tempB = head;
            while (temp!=null){
                if (a-b!=k){
                    temp=temp.next;
                    a++;
                }else {
                    temp=temp.next;
                    tempB=tempB.next;
                    a++;
                    b++;
                }
            }
            return tempB;
        }
        //用栈或者队列？
        public ListNode getKthFromEnd2(ListNode head, int k) {
            if (head==null)return null;
            Stack<ListNode> stack = new Stack<>();
            ListNode temp = head;
            while (head!=null){
                stack.push(head);
                head=head.next;
            }
            while (k!=0){
                temp = stack.pop();
                k--;
            }
            return temp;
        }
    }
}
