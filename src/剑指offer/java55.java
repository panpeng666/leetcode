package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    }

