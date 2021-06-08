package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class java112 {
    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：false
     * 示例 3：
     *
     * 输入：root = [1,2], targetSum = 0
     * 输出：false
     *  
     *
     * 提示：
     *
     * 树中节点的数目在范围 [0, 5000] 内
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
        boolean flag = false;
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root==null){
                System.out.println("root is null ,targetSum="+targetSum);

                    flag = true;
                    return flag;

            }
           else {
                System.out.println("root.val="+root.val+"  targetSum="+targetSum);
                if (root.left == null && root.right == null) {
                    System.out.println("此时到最子树");
                    System.out.println("root.val="+root.val+"  targetSum="+targetSum);
                    System.out.println("=================");
                    if (root.val == targetSum) {
                        flag = true;
                        return flag;
                    }
                }
                if (root.left!=null) hasPathSum(root.left, targetSum - root.val);
                if (root.right!=null) hasPathSum(root.right, targetSum - root.val);
            }
            return flag;
        }
        public boolean hasPathSum1(TreeNode root, int targetSum) {
            if (root==null)return false;
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            queue1.add(root);
            queue2.add(root.val);
            while (!queue1.isEmpty()){
                int size = queue1.size();
                while (size>0){
                TreeNode temp =queue1.poll();
                int tempVal = queue2.poll();
                if (temp.left!=null){
                    queue1.add(temp.left);
                    queue2.add(tempVal+temp.val);
                }
                if (temp.right!=null){
                    queue1.add(temp.right);
                    queue2.add(tempVal+temp.val);
                }
                if (temp.left==null&&temp.right==null){
                    System.out.println("===");
                    System.out.println(tempVal);
                    System.out.println(temp.val);
                    if (tempVal+temp.val==targetSum)
                        return true;
                }
                size--;
                }
            }
            return false;
        }

    }
    /**
     root.val=5  targetSum=22
     root.val=4  targetSum=17
     root.val=11  targetSum=13
     root.val=7  targetSum=2
     root is null ,targetSum=-5
     root is null ,targetSum=-5
     root.val=2  targetSum=2
     root is null ,targetSum=13
     root.val=8  targetSum=17
     root.val=13  targetSum=9
     root is null ,targetSum=-4
     root is null ,targetSum=-4
     root.val=4  targetSum=9
     root is null ,targetSum=5
     root.val=1  targetSum=5
     root is null ,targetSum=4
     root is null ,targetSum=4

     */
}
