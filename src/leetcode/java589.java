package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *  
 *
 * 进阶：
 *
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        /**
         * 递归
         * @param root
         * @return
         */
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root==null)return res;
            dfs(root,res);
            return res;
        }
        public void dfs(Node root,List<Integer> res){
            if (root==null) return;
            res.add(root.val);
            for (Node temp:root.children){
                dfs(temp,res);
            }
        }
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root==null)return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node tempNode = stack.pop();
            res.add(tempNode.val);
            if (tempNode.children.size()!=0){
                for (int i=tempNode.children.size()-1;i>=0;i--){
                    stack.push(tempNode.children.get(i));
                }
            }
        }
        return res;
    }

}
