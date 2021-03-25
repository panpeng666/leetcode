package 剑指offer;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java68_错题 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        //深度或者广度找到这两个节点，再对比其父节点，此时可以迭代
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (!p.equals(q)){
                p=dfs(root,p);
                q=dfs(root, q);
                lowestCommonAncestor(root,p,q);
            }
            return q;
        }
        //实现一个函数，可以返回目标节点的父节点
        //你妹，还要非空判断
        public TreeNode dfs(TreeNode root,TreeNode p){
            TreeNode temp = root;

            if (root.left!=null||root.left.equals(p)||root.right!=null||root.right.equals(p)){
                return temp;
            }
            dfs(root.left,p);
            dfs(root.right,p);
            return temp;
        }

    }
    //
    class Solution1 {
        /**
         * 二叉树的最近公共祖先
         * 思路：
         * 三种情况：
         * 1、p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
         * 2、p q 都在左子树
         * 3、p q 都在右子树
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                // p q 一个在左，一个在右
                return root;
            }
            if (left != null) {
                // p q 都在左子树
                return left;
            }
            if (right != null) {
                // p q 都在右子树
                return right;
            }
            return null;
        }
        //以上方法解说版本
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (p.val == root.val || q.val == root.val) {//这个就是只要有一个是根节点那么公共祖先一定是根节点,这个画图就可以了
                return root;
            }
            TreeNode treeNode = lowestCommonAncestor1(root.left, p, q);//这个其实就是看一下p或者q是不是在左子树这里
            TreeNode treeNode1 = lowestCommonAncestor1(root.right, p, q);//这个其实就是看一下p或者q是不是在右子树这里
            if (treeNode != null && treeNode1 != null) {//这说明就是p和q一个在左子树一个在右子树
                return root;
            } else if (treeNode == null && treeNode1 != null) {
                //treeNode==null说明整颗左子树这里其实没有p或者q
                //因为只有有一个p或者q就会返回root,不会返回null
                //都在右子树这里
                return treeNode1;
            } else if (treeNode != null && treeNode1 == null) {//这其实就说明整颗右子树这里没有p或者q
                return treeNode;
            } else {//两个都是null
                return null;
            }
        }
    }
}
