package 张哥21天算法计划.第二周.Day12二叉搜索树基础;

public class java701 {
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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root==null)return new TreeNode(val);
            if (root.left.val>val){
                insertIntoBST(root.left,val);
            }
            if (root.right.val>val){
                insertIntoBST(root.right,val);
            }
            return root;
        }
    }
}
