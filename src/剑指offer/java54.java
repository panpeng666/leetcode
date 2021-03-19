package 剑指offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class java54 {
    /**
     * Definition for a binary tree node.
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public int kthLargest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            //中序遍历把所有值set进去
            Stack<TreeNode> stack = new Stack<>();
            TreeNode temp = root;
            while (!stack.isEmpty()||temp!=null){
                while (temp!=null){
                    stack.push(temp);
                    temp=temp.left;
                }
                if (!stack.isEmpty()){
                    temp=stack.pop();
                    list.add(temp.val);
                    temp=temp.right;
                }
            }
            Arrays.sort(list.toArray());
            return  list.get(list.size()-k);
        }
    }
}
