package leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java21 {
    /**
     * Definition for singly-linked list.
     *      */
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
         //递归

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //先处理特殊情况
            if (l1==null)return l2;
            else if (l2==null)return l1;

            if (l1.val<l2.val){
                l1.next=mergeTwoLists(l1.next,l2);
                return l1;
            }else {
                l2.next=mergeTwoLists(l1,l2.next);
                return l2;
            }

        }
        //迭代
        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            while (l1!=null&&l2!=null){
                if (l1.val>l2.val){
                    temp.next=l2;
                    l2=l2.next;
                }else {
                    temp.next=l1;
                    l1=l1.next;
                }
                temp=temp.next;
            }
            if (l1!=null)temp.next=l1;
           else if (l2!=null)temp.next=l2;
           return head.next;
        }

    }
}
