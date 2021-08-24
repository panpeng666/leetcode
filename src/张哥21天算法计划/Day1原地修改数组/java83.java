package 张哥21天算法计划.Day1原地修改数组;

public class java83 {
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     *
     * 返回同样按升序排列的结果链表。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     * 示例 2：
     *
     *
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     *  
     *
     * 提示：
     *
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            //也是双指针法
            if (head==null)return head;
            ListNode slow = head;
            ListNode fast = head;
            while (fast!=null){
                if (slow.val!=fast.val){
                    slow.next=fast;
                    slow=slow.next;
                }
                fast=fast.next;
            }
            slow.next=null;
            return head;
        }
    }
}
