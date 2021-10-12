package 张哥21天算法计划.第二周.Day11二叉树训练;

public class java114 {
    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [0]
     * 输出：[0]
     *  
     *
     * 提示：
     *
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     *  
     *
     * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public void flatten(TreeNode root) {
            if (root==null)return;
            flatten(root.left);
            flatten(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right=left;
            root.left=null;
            TreeNode p = root;
            while (p.right!=null){
                p=p.right;
            }
            p.right=right;
        }
        //抬手先默写一个先序遍历
        public void sort(TreeNode treeNode){
            if (treeNode==null)return;
            System.out.println(treeNode.val);
            sort(treeNode.left);
            sort(treeNode.right);
        }

    }

}
