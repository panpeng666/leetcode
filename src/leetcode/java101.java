package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java101 {
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
        //走迭代的话就直接层序遍历出来，一个list一个list去判断
        public boolean isSymmetric(TreeNode root) {
            if (root==null)return true;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                List<Integer>  list = new ArrayList<>();
                int size = queue.size();
                TreeNode temp = queue.poll();
                while (size>0){
//                    if (temp!=null) {
                        list.add(temp.val);
                        if (temp.left!=null){
                            queue.add(temp.left);
                        }
                        if (temp.right!=null) {
                            queue.add(temp.right);
                        }
//                    }else {
//                        list.add(0);
//                        queue.add(temp.left);
//                        queue.add(temp.right);
//                    }
                    size--;
                    }
                System.out.println(list.toArray().toString());
                  if(!check(list)){
                      return check(list);
                  }
                }
            return true;
            }
        private Boolean check(List<Integer> list){
            if (list.size()==1)return true;
            int length = list.size()-1;
            for (int i=0;i<(length/2);i++){
                if (list.get(i)!=list.get(length-i)){
                    return false;
                }
            }
            return true;
        }

        public boolean isSymmetric1(TreeNode root) {
            if (root==null)return true;
            return check(root.left,root.right);
        }
        public boolean check(TreeNode a,TreeNode b){
            if (a==null&&b==null){
                return true;
            }
            if (a==null||b==null){
                return false;
            }
            if (a.val!=b.val){
                return false;
            }
            return check(a.left,b.right)&&check(a.right,b.left);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left=b;
        a.right=c;
        System.out.println(solution.isSymmetric(a));


    }
}
