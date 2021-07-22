package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class java07 {
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        //前序左中右，中序根左右
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Queue<TreeNode> queue = new LinkedList<>();
            if (preorder.length==0)return null;
            for (int i=0;i<inorder.length;++i){
                TreeNode temp = new TreeNode(inorder[i]);
                queue.add(temp);
                //把这个节点的子节点丢进去
                if ((2*(i+1)-1)<inorder.length){
                    TreeNode temp2 = new TreeNode(inorder[(2*(i+1)-1)]);
                    queue.add(temp2);
                }else queue.add(null);
                if (2*(i+1)<inorder.length){
                    TreeNode temp3 = new TreeNode(inorder[(2*(i+1))]);
                    queue.add(temp3);
                }else queue.add(null);
            }
            while (!queue.isEmpty()){

            }
            return null;
        }
    }
}
