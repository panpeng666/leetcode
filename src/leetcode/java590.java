package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
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
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class java590 {
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
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root==null)return res;
            LRD(root,res);
            res.add(root.val);
            return res;
        }

        public void LRD(Node root,List<Integer> res){
            if (root==null)return;
            for (Node temp:root.children){
                LRD(temp,res);
                res.add(temp.val);
            }
        }

        /**
         *迭代
         * @param root
         * @return
         */
        public List<Integer> postorder1(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root==null)return res;
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()){
                Node temp = stack1.pop();
                if (temp.children!=null){
                    for (Node tempChildren:temp.children){
                        stack1.push(tempChildren);
                    }
                }
                stack2.push(temp);
            }
            while (!stack2.isEmpty()){
                res.add(stack2.pop().val);
            }
            return res;
        }
    }
}
