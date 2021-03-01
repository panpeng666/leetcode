package 剑指offer;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java27 {
    /**
     * Definition for a binary tree node.
     */
    static   public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }
  static   class Solution {
          //递归
        public TreeNode mirrorTree(TreeNode root) {
            if(root==null){return null;}
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirrorTree(root.left);
            mirrorTree(root.right);

            return root;
        }

        //stack栈
        public TreeNode mirrorTree1(TreeNode root) {
            if(root==null)return null;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                if (temp.left!=null){stack.push(temp.left);}
                if (temp.right!=null){stack.push(temp.right);}
                TreeNode node = temp.left;
                temp.left=temp.right;
                temp.right=node;

            }
            return root;
        }
    }



}
