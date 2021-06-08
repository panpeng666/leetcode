package 剑指offer;

import java.util.*;

public class java55 {
/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

    /**
     * Definition for a binary tree node.
     *      */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
         public void depth(TreeNode node){
             if (node==null)return;
             Queue<TreeNode> queue = new LinkedList<>();
             int depth=0;
             int a=0;
             queue.offer(node);
             while (!queue.isEmpty()){
                 a = queue.size();

                     while (a > 0) {
                         TreeNode temp = queue.poll();
                         if (temp!=null) {
                             queue.offer(temp.left);
                             queue.offer(temp.right);
                         }
                        a--;
                     }
                     depth++;
                 }
             }


         }


        public int maxDepth(TreeNode root) {
            if (root==null)return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth=1;
            int n=0;
            while (!queue.isEmpty()){
                List<Integer> levelList=new ArrayList<>();
                n=queue.size();
                while (n>0){
                    TreeNode temp = queue.poll();
                    if (temp!=null){
                        levelList.add(temp.val);
                        queue.offer(temp.left);
                        queue.offer(temp.right);
                    }
                    n--;
                }
                if (levelList.size()>0){
                    depth++;
                }
            }
            return depth;
        }

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     *  
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \  / \
     *    3  3  n  n
     *   / \ / \
     *  4   4
     * 返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    //用层序遍历，如果有2层都不平衡就返回
    //换个思路，应该层序遍历到第一个不平衡的层的时候，记录一下层数，然后最深层减去他，大于1就是不平衡二叉树
    public boolean isBalanced(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        int flag = 0;
        while (queue.isEmpty()){
            int  size=queue.size();
            List<TreeNode> list = new ArrayList<>();
            while (size>0){
                TreeNode temp = queue.poll();
                list.add(temp);
                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
                size--;
            }
            deep++;
            if (list.size()<Math.pow(2,deep)){
                flag=deep;
                break;
            }
            flag=deep;
        }
        System.out.println(flag);
        System.out.println(dfs(root));
        if (dfs(root)-flag>1){
            return false;
        }else return true;


    }

    public int dfs(TreeNode root) {
        if (root==null)return 0;
        else {
            int a = dfs(root.left);
            int b = dfs(root.right);
            return Math.max(a,b);
        }

    }
}

