package 张哥21天算法计划.第二周.Day12二叉搜索树基础;

public class java450 {
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
        public TreeNode deleteNode(TreeNode root, int val) {
            if (root==null)return null;
            if (root.val==val){
                if (root.left==null)return root.right;
                if (root.right==null)return root.left;

                //特殊情况处理
                TreeNode temp = getMin(root.right);
                root.val=temp.val;
                root.right = deleteNode(root.right,temp.val);
            }else if (root.val>val){
               root.left= deleteNode(root.left,val);
            }else if (root.val<val){
               root.right= deleteNode(root.right,val);
            }
            return root;
        }
        public TreeNode getMin(TreeNode treeNode){
            while (treeNode.left!=null){
                treeNode=treeNode.left;
            }
            return treeNode;
        }
    }

}
