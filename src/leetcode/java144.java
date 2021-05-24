package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java144 {
    public static class TreeNode {
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
   static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root==null)return list;
            preOrder(root,list);
            return list;
        }
        private void preOrder(TreeNode root,List<Integer> list){
            if (root==null)return;
            list.add(root.val);
            if (root.left!=null){preOrder(root.left,list);}
            if (root.right!=null){preOrder(root.right,list);}
        }

        public static List<Integer> preorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root==null)return list;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                list.add(temp.val);
                System.out.println(temp.val);
                if (temp.right!=null){stack.push(temp.right);}
                if (temp.left!=null){stack.push(temp.left);}
            }
            return list;
        }

        public static   void main(String[] args) {
            Solution solution = new Solution();
            TreeNode node = new TreeNode();
            TreeNode node1 = new TreeNode(2);
            TreeNode node2 = new TreeNode(3);
            node.val=1;
            node.left=node1;
            node.right=node2;
            System.out.println(preorderTraversal1(node).toArray());
        }

    }


}
