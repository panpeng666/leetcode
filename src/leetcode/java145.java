package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root==null)return res;
            LDR(root,res);
            return res;
        }
        public void LDR(TreeNode root,List<Integer> res){
            if (root==null)return;
            LDR(root.left,res);
            res.add(root.val);
            LDR(root.right,res);
        }

        /**
         * 迭代
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root==null)return res;
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);

            while (!stack1.isEmpty()){
                TreeNode temp = stack1.pop();
                if (temp.left!=null){
                    stack1.push(temp.left);
                }
                if (temp.right!=null){
                    stack1.push(temp.right);
                }
                stack2.push(temp);
            }
            while (!stack2.isEmpty()){
                res.add(stack2.pop().val);
            }
            return res;
        }
    }

}
