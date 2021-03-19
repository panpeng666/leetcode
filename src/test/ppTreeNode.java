package test;

import java.util.*;

//二叉树遍历练习
class TreeNode {
    //定义树
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val: " + val;
    }

    //定义访问函数（只访问当前的val）
    public static void visit(TreeNode treeNode) {
        System.out.print(treeNode.val + " ");
    }

    //练习
    public static void sort1(TreeNode node) {
        if (node == null) return;
        visit(node);
        sort1(node.left);
        sort1(node.right);
    }

    public static void sort1_1(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            visit(temp);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    //中序遍历 左根右
    public static void sort2(TreeNode node) {
        if (node == null) return;
        sort2(node.left);
        visit(node);
        sort2(node.right);
    }

    //中序遍历 左根右
    public static void sort2_2(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = node;
        while (temp.left != null) {
            stack.push(temp);
            temp = temp.left;
        }
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            visit(treeNode.left);
            visit(treeNode.right);
        }
    }


    public static void sort3(TreeNode node) {
        if (node == null) return;
        sort3(node.left);
        sort3(node.right);
        visit(node);
    }

    public static void sort3_3(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = node;
        while (temp != null) {
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
            stack.push(temp);

        }
    }


    //2021/3/1再次练习递归遍历
    //先序
    public static void preOrder(TreeNode node) {
        if (node == null) return;
        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void preOrderStack(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            visit(temp);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }


    //前序遍历
    //二叉树的前序遍历即先遍历根结点再遍历左结点最后遍历右结点  ABC
    //递归遍历,但是递归还是一如既往的低效率
    public static void preOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        visit(node);
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);
    }

    //不使用递归进行前序遍历（使用栈的思想）
    public static void preOrderRecursionStack(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        if (node == null) return;
        treeStack.push(node);
        while (!treeStack.isEmpty()) {
            TreeNode tempTree = treeStack.pop();
            if (tempTree != null) {
                result.add(tempTree.val);
                treeStack.push(tempTree.left);
                treeStack.push(tempTree.right);
            }
        }
        System.out.println(result.toString());
    }

    //中序遍历
    //先访问左节点，再访问根节点，最后访问右节点 BAC
    //迭代方法。
    public static void minOrderRecursion(TreeNode node) {
        if (node == null) return;
        minOrderRecursion(node.left);
        visit(node);
        minOrderRecursion(node.right);
    }

    //非迭代
    public static void minOrderRecursionStack(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> treeNodeStack = new Stack<>();
//            List<Integer> result = new ArrayList<>();

        TreeNode temp = node;
        while (temp != null || !treeNodeStack.isEmpty()) {

            while (temp != null) {
                System.out.println("===入栈" + temp);
                treeNodeStack.push(temp);
                temp = temp.left;
            }
            if (!treeNodeStack.isEmpty()) {
                temp = treeNodeStack.pop();
//                    System.out.println("==出栈"+temp);
//                    result.add(temp.val);
                temp = temp.right;
//                    System.out.println("temp 赋予新值"+temp);
            }


        }

//        System.out.println(result.toString());


    }


    /**
     * 后续遍历(迭代实现)
     *
     * @param node
     */

    static public void posOrderRecur(TreeNode node) {
        if (node == null) return;
        posOrderRecur(node.left);
        posOrderRecur(node.right);
        visit(node);
    }

    static public void posOrderRecur1(TreeNode node) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack1.push(node);
        TreeNode temp;
        while (!stack1.isEmpty()) {
            temp = stack1.pop();
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
            stack2.push(temp);
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        System.out.println(result.toString());
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(10);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        order4(a);
        System.out.println();
        test4_1(a);
        System.out.println();
//        order4(a);
//        Stack<Integer> stack = new Stack();
//        stack.push(1);
//        stack.push(null);
//        System.out.println(stack.peek());
    }


    static public void perOrder(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        stack.push(node);
        TreeNode temp = node;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp != null) {
                list.add(temp.val);
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }
        System.out.println(list.toString());
    }


    static public void minOrder(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(node);
        TreeNode temp = node;
        while (!stack.isEmpty()) {


            while (temp != null) {
                temp = temp.left;
                stack.push(temp);
            }

            temp = stack.pop();
            list.add(temp.val);


        }
        System.out.println(list.toString());

    }

    //每日复习 3.3
    //递归先序
    static public void test1(TreeNode node) {
        if (node == null) return;
        visit(node);
        test1(node.left);
        test1(node.right);
    }

    //递归中序
    static public void test2(TreeNode node) {
        if (node == null) return;
        test2(node.left);
        visit(node);
        test2(node.right);
    }

    //递归后序
    static public void test3(TreeNode node) {
        if (node == null) return;
        test3(node.left);
        test3(node.right);
        visit(node);
    }

    //迭代前序
    static public void test1_1(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            visit(temp);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    //迭代中序
    static public void test2_2(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(node);
        TreeNode temp =node;
        while (!stack.isEmpty() || temp != null) {

            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop();
                visit(temp);
                temp=temp.right;
            }

        }
    }
    //迭代后序
    static public void test3_3(TreeNode node){
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> ans = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ans.push(temp);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }

        }
        while (!ans.isEmpty()){
            TreeNode res = ans.pop();
            visit(res);
        }
    }


    //每日一练
    public void order1(TreeNode node){
        if (node==null)return;
        visit(node);
        order1(node.left);
        order1(node.right);
    }
    public void order2(TreeNode node){
        if (node==null)return;
        order2(node.left);
        visit(node);
        order2(node.right);
    }
    public void order3(TreeNode node){
        if (node==null)return;
        order3(node.left);
        order3(node.right);
        visit(node);
    }


    public void order1_1(TreeNode node){
        if (node==null)return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            visit(temp);
            if (temp.right!=null){stack.push(temp.right);}
            if (temp.left!=null){stack.push(temp.left);}
        }
    }

    public void order3_3(TreeNode node){
        if (node==null)return ;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.push(temp);
            if (temp.right!=null){stack.push(temp.right);}
            if (temp.left!=null){stack.push(temp.left);}
        }
        while (!res.isEmpty()){
            visit(res.pop());
        }
    }
    public static void order2_2(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = node;
        while (!stack.isEmpty()||temp!=null){

            while (temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()){
                temp=stack.pop();
                visit(temp);
                temp=temp.right;
            }
        }
    }

    public static void order4(TreeNode node){
        if (node==null)return;
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            visit(temp);
            if (temp.left!=null)queue.offer(temp.left);
            if (temp.right!=null)queue.offer(temp.right);

        }
    }




public void test1_1_1(TreeNode node){
        if (node==null)return;
        visit(node);
        test1_1_1(node.left);
        test1_1_1(node.right);

}
public void test1_a(TreeNode node){
        if (node==null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            visit(temp);
            if (temp.right!=null){stack.push(temp.right);}
            if (temp.left!=null){stack.push(temp.left);}

        }
}




    public static void test2_1(TreeNode node){
        if (node==null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = node;
        while (!stack.isEmpty()||temp!=null){

            while (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if (!stack.isEmpty()){
                temp=stack.pop();
                visit(temp);
                temp=temp.right;
            }


        }

    }










    public static void test3_a(TreeNode node){
        if (node==null)return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.push(temp);
            if (temp.left!=null){stack.push(temp.left);}
            if (temp.right!=null){stack.push(temp.right);}
        }
        while (!res.isEmpty()){
            visit(res.pop());
        }
    }


    public static void test4_1(TreeNode node){
        if (node==null)return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            visit(temp);
            if (temp.left!=null){queue.offer(temp.left);}
            if (temp.right!=null){queue.offer(temp.right);}
        }

    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList=new ArrayList<>();
        int levelNum=0;//记录某层具有多少个节点
        Queue<TreeNode> treeQueue=new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()){
            levelNum=treeQueue.size();
            List<Integer> levelList=new ArrayList<>();
            while(levelNum>0){
                TreeNode tempNode=treeQueue.poll();
                if(tempNode!=null){
                    levelList.add(tempNode.val);
                    treeQueue.add(tempNode.left);
                    treeQueue.add(tempNode.right);
                }
                levelNum--;
            }
            if(levelList.size()>0)
                resultList.add(levelList);
        }
        return resultList;
    }











}
