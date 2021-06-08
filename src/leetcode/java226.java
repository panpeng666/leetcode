package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 翻转一棵二叉树。

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 备注:
 这个问题是受到 Max Howell 的 原问题 启发的 ：

 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/invert-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java226 {
    public  class TreeNode {
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
             DfsInvertTree(root);
             return root;
        }
        public void DfsInvertTree(TreeNode root){
            if (root==null) return;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = root.left;
            DfsInvertTree(root.left);
            DfsInvertTree(root.right);
        }


        public TreeNode invertTree1(TreeNode root) {
            if (root==null)return null;
            if (root.left==null&&root.right==null)return root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size>0){
                    TreeNode temp = queue.poll();
                    TreeNode temp1 = temp.left;
                    temp.left=temp.right;
                    temp.right=temp1;
                    if (temp.left!=null){
                        queue.add(temp.left);
                    }
                    if (temp.right!=null){
                        queue.add(temp.right);
                    }
                    size--;
                }
            }
            return root;
        }
    }
}
