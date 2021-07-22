package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class java501_notFinish {
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     *
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     * 返回[2].
     *
     * 提示：如果众数超过1个，不需考虑输出顺序
     *
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        //第一想法中序递归二叉树，然后用hashset判断
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        public int[] findMode(TreeNode root) {
            if (root==null) return null;
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            dfs(root);
            if (list.size()==1)return new int[]{list.get(0)};
            boolean flag = false;
            for (int i=0;i<list.size()-1;i++){
                if (list.get(i)!=list.get(i+1)){
                    set2.add(list.get(i));
                }else {
                    flag=true;
                    set1.add(list.get(i));
                }
            }
            HashSet set3 = new HashSet();
            if (flag){
                set3=set1;}
            else set3=set2;
                for (Iterator<Integer> iter = set3.iterator(); iter.hasNext();) {
                    list2.add(iter.next());
                }
                int [] a = new int[list2.size()];
                for (int j=0;j<list2.size();j++){
                    a[j]=list2.get(j);
                }
                return a;
            }


        public void dfs(TreeNode root){
            if (root==null)return;
            if (root.left!=null)dfs(root.left);
            list.add(root.val);
            if (root.right!=null)dfs(root.right);

        }

        public void test(String s){
            int count=1;
            for (int i =0;i<s.length();i++){
                for (int j = i+1;j<s.length()-1;j++){
                    if (s.indexOf(i)==s.indexOf(j)){
                        String temp = s.substring(i,j);
                        System.out.println(count+"."+"    "+temp+"    "+(j-i-1));
                        count++;
                    }
                }
            }
        }


        class Solution1 {
            List<Integer> answer = new ArrayList<Integer>();
            int base, count, maxCount;

            public int[] findMode(TreeNode root) {
                dfs(root);
                int[] mode = new int[answer.size()];
                for (int i = 0; i < answer.size(); ++i) {
                    mode[i] = answer.get(i);
                }
                return mode;
            }

            public void dfs(TreeNode o) {
                if (o == null) {
                    return;
                }
                dfs(o.left);
                update(o.val);
                dfs(o.right);
            }

            public void update(int x) {
                if (x == base) {
                    ++count;
                } else {
                    count = 1;
                    base = x;
                }
                if (count == maxCount) {
                    answer.add(base);
                }
                if (count > maxCount) {
                    maxCount = count;
                    answer.clear();
                    answer.add(base);
                }
            }
        }

//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/er-cha-sou-suo-shu-zhong-de-zhong-shu-by-leetcode-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//
//
//
//            for (int temp:list){
//                if (set.contains(temp)){
//                    list1.add(temp);}
//                else {
//                    set.add(temp);
//                    list2.add(temp);
//                }
//            }
//            if (list1.size()==0&&list2.size()!=0){
//                int [] b = new int[list2.size()];
//                for (int i=0;i<b.length;i++){
//                    b[i]=list1.get(i);
//                }
//                return b;
//            }
//            int [] a = new int[list1.size()];
//            for (int i=0;i<a.length;i++){
//                a[i]=list1.get(i);
//            }
//            return a;
class Solution3 {
    int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
}
//        复杂度分析
//
//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/er-cha-sou-suo-shu-zhong-de-zhong-shu-by-leetcode-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }
}
