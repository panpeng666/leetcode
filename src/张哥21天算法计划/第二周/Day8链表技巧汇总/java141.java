package 张哥21天算法计划.第二周.Day8链表技巧汇总;

public class java141 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head==null)return false;
            ListNode slow = head;
            ListNode fast = head;
            while(true){
                if(fast.next==null)return false;
                fast=fast.next;
                if(fast.next==null)return false;
                fast=fast.next;
                slow=slow.next;
                if(fast==slow)return true;
            }
        }
    }
}
