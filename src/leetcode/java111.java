package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class java111 {
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
        public int minDepth(TreeNode root) {
            if (root==null)return 0;
            if (root.left==null&&root.right==null)return 1;
//            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int deep=1;
            while (!queue.isEmpty()){
                int size = queue.size();
//                if (size!=Math.pow(2,deep)&&deep!=0){
//                    return deep;
//                }
                while (size>0){
                    TreeNode temp = queue.poll();
                    if (temp.right==null&&temp.left==null)
                        return deep;
                    if (temp.left!=null){
                        queue.add(temp.left);
                    }
                    if (temp.right!=null){
                        queue.add(temp.right);
                    }
                    size--;
                }
                deep++;
            }
            return -1;
        }
    }

    public int minDepth1(TreeNode root) {
        if (root==null)return 0;
        if (root.left==null&&root.right==null)return 1;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        if (root.left==null||root.right==null)return left+right+1;
        return Math.min(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.right=b;
        b.right=c;
        c.right=d;
        d.right=e;
        Solution solution = new Solution();
        System.out.println(solution.minDepth(a));
    }
}
