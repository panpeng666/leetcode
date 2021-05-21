package leetcode;



import java.util.*;

public class java275 {
   public class TreeNode {
        //定义树
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }}
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<String>();
            constructPaths(root, "", paths);
            return paths;
        }

        public void constructPaths(TreeNode root, String path, List<String> paths) {
            if (root != null) {
                StringBuffer pathSB = new StringBuffer(path);
                pathSB.append(Integer.toString(root.val));
                if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                    paths.add(pathSB.toString());  // 把路径加入到答案中
                } else {
                    pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                    constructPaths(root.left, pathSB.toString(), paths);
                    constructPaths(root.right, pathSB.toString(), paths);
                }
            }
        }
        public List<String> binaryTreePaths1(TreeNode root) {
            List<String> res = new ArrayList<>();
            dfs(root, "", res);
            return res;
        }

        private void dfs(TreeNode root, String path, List<String> res) {
            //如果为空，直接返回
            if (root == null)
                return;
            //如果是叶子节点，说明找到了一条路径，把它加入到res中
            if (root.left == null && root.right == null) {
                res.add(path + root.val);
                return;
            }
            //如果不是叶子节点，在分别遍历他的左右子节点
            dfs(root.left, path + root.val + "->", res);
            dfs(root.right, path + root.val + "->", res);
        }

        /**
         * 走栈思想的前序遍历试试
         * 先写前序遍历，再改成本题
         * 卧槽是路径记录和前序一起入栈保存，牛比
         * @param root
         * @return
         */
        public List<String> binaryTreePaths2(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root==null) return res;
            Stack<Object> stack = new Stack<>();
            stack.push(root);
            String sb = String.valueOf(root.val);
            stack.push(sb);
            while (!stack.isEmpty()){
                String path = stack.pop().toString();
                TreeNode temp = (TreeNode) stack.pop();
                if (temp.left==null&&temp.right==null){
                    res.add(path);
                }
                if (temp.right!=null){
                    stack.push(temp.right);
                    stack.push(path+"->"+temp.right.val);
                }
                if (temp.left!=null){
                    stack.push(temp.left);
                    stack.push(path+"->"+temp.left.val);
                }
            }
            return res;
        }

        /**
         * 走层序遍历思想
         * @param root
         * @return
         */
        public List<String> binaryTreePaths3(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root==null)return res;
            Queue<Object> queue = new LinkedList<>();
            queue.add(root);
            queue.add(String.valueOf(root.val));
            while (!queue.isEmpty()){
                TreeNode node = (TreeNode)queue.poll();
                String temp = (String) queue.poll();
                if (node.right==null&&node.left==null){
                    res.add(temp);
                }
                if (node.left!=null){
                    queue.add(node.left);
                    queue.add(temp+"->"+node.left.val);
                }
                if (node.right!=null){
                    queue.add(node.right);
                    queue.add(temp+"->"+node.right.val);
                }
            }
            return res;
        }

    }


}
