package leetcode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 *
 *
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java108 {
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
    //高度平衡得搜索二叉树意味着会取中间得数作为根节点
    //抽象成递归方法的话，最小可以处理2-3长度得数组
    //先试试把
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            TreeNode tree = new TreeNode();
            if (nums.length==0)return tree;
           return dfs(nums,0,nums.length-1);

        }

        public TreeNode dfs(int[] nums,int left,int right){
            if (left>right)return null;
            int mid = left+((right-left)>>1);
            TreeNode treeNode = new TreeNode(nums[mid]);
            //此时需要参考二分法的思路
            treeNode.left=dfs(nums,left,mid-1);
            treeNode.right=dfs(nums,mid+1,right);
            return treeNode;
        }
    }
}
