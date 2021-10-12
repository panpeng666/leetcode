package 张哥21天算法计划.第二周.Day12二叉搜索树基础;

public class java700 {
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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root==null)return null;
            if (root.val==val)return root;
            if (root.val<val)
                return searchBST(root.right,val);
            if (root.val>val)
                return searchBST(root.left,val);

            return null;
        }
    }
}
