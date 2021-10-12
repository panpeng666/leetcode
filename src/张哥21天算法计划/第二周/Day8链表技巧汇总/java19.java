package 张哥21天算法计划.第二周.Day8链表技巧汇总;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //双指针
            //加一个头结点更好处理
            ListNode pre = new ListNode(0);
            pre.next=head;
            ListNode a =pre;
            ListNode b =pre;

            while (a!=null){
                if (n>0){
                    a=a.next;
                    n--;
                    continue;
                }
                a=a.next;
                if (a==null){
                    b.next=b.next.next;
                }
                b=b.next;
            }
            return pre.next;
        }
    }
}
