package 张哥21天算法计划.第二周.Day11二叉树训练;

public class java226 {

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
        public TreeNode invertTree(TreeNode root) {
            if (root==null)return null;
            TreeNode temp = root.left;
            root.left=root.right;
            root.right=temp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
