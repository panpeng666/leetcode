package leetcode;

public class java404 {
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
    /**
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        //迭代
        int temp=0;
        public int sumOfLeftLeaves(TreeNode root) {

            dfs(root);
            return temp;
        }
        public void dfs(TreeNode root){
            if (root==null)return;
            if (root.left!=null){
                if(root.left.left==null&&root.left.right==null) temp+=root.left.val;
                dfs(root.left);
            }
            if (root.right!=null){
                dfs(root.right);
            }
        }
    }
}
