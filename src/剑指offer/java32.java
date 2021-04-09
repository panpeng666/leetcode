package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class java32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null)return null;
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int flag = 0;
            while (!queue.isEmpty()){
                flag=queue.size();
                List<Integer> tempList = new ArrayList<>();
                while (flag>0) {
                    TreeNode temp = queue.poll();
                    if (temp!=null) tempList.add(temp.val);
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                    flag--;
                }
                ans.add(tempList);
            }
            return ans;
        }
    }
}
