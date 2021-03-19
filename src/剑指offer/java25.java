package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class java25 {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * Definition for singly-linked list.
     * */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    static class Solution {
          //第一反应就是双指针
        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

           ListNode b = new ListNode(0);
            ListNode a = b;
           while (l1!=null&&l2!=null){
               if (l1.val<=l2.val){
                   a=l1;
                   l1=l1.next;
               }else {
                   a=l2;
                   l2=l2.next;
               }

           }
            return b.next;
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dum = new ListNode(0), cur = dum;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 != null ? l1 : l2;
            return dum.next;
        }

//        作者：jyd
//        链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/solution/mian-shi-ti-25-he-bing-liang-ge-pai-xu-de-lian-b-2/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


        static public void test(ListNode a){
            while (a!=null){
                System.out.println(a.val);
                a=a.next;
            }
            System.out.println();
        }


        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode a = new ListNode(3);
            ListNode b = new ListNode(4);
            a.next=new ListNode(5);
            a.next.next=new ListNode(6);
            b.next=new ListNode(5);
            b.next.next=new ListNode(8);
            test(a);
            test(b);
            ListNode temp = solution.mergeTwoLists(a,b);
            test(temp);
        }
    }
}
