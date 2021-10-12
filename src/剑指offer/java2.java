package 剑指offer;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class java2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //就这！双指针！
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ans = new ListNode(0);
            int flag = 0;
            ListNode n = ans;
            while (!(l1 == null && l2 == null && flag == 0)) {
                int l1_val = 0;
                int l2_val = 0;
                //防止空指针
                if (l1 != null) {
                    l1_val = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2_val = l2.val;
                    l2 = l2.next;
                }
                int temp = l1_val + l2_val + flag;
                //判断是否进位
                if (temp >= 10) {
                    temp = temp - 10;
                    flag = 1;
                } else flag = 0;
                //创建子节点
                ListNode node = new ListNode(temp);


                n.next = node;
                n = n.next;
            }
            return ans.next;
        }
    }
}
