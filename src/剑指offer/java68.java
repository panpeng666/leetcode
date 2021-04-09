package 剑指offer;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //把所有结果列一下
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root.val==p.val||root.val==q.val){
            return root;
        }
        TreeNode temp1 =  lowestCommonAncestor(root.left,p,q);
        TreeNode temp2 =  lowestCommonAncestor(root.right,p,q);
        if (temp1!=null&&temp2!=null){
            return root;
        }else if (temp1!=null&&temp2==null){
            return temp1;
        }else if (temp2!=null&&temp1==null){
            return temp2;
        }
        return null;
    }
    //注意这个是个搜索二叉树，左节点<根<右节点
    public void dfs (TreeNode root,TreeNode p){
        if (root.val==p.val){
            return;
        }
        if (root.val>p.val){
            dfs(root.left,p);
        }else {
            dfs(root.right,p);
        }
    }
}
