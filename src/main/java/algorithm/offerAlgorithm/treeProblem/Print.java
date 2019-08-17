package algorithm.offerAlgorithm.treeProblem;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:24 2019-03-29
 * @ Description： 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * @ Modified By：
 * @Version: $
 */
public class Print {

    /**
     * 首先是按照行来遍历的，普通的是按照队列
     * 其次要求每一行顺序不同
     * 如果先拿出来的再下一行就要后出来，因为采用stack,而且因为stack的先进后出
     * 在pop的时候如果add，会影响新的pop
     *
     * 因此需要采取两个stack
     * 而且要考虑到一个逆向的时候要先添加right节点
     * 正向的时候需要先添加left节点，使用一个row
     *
     * 因为采用两个stack，不需要last 和 nlast
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
       if (pRoot == null) return result;
       Stack<TreeNode> stack1 = new Stack<>();
       stack1.push(pRoot);
       Stack<TreeNode> stack2 = new Stack<>();
       ArrayList<Integer> res = new ArrayList<>();
       while (!stack1.isEmpty() || !stack2.isEmpty()) {
           while (!stack1.isEmpty()) { // stack1读，stack2存
               TreeNode node = stack1.pop();
               res.add(node.val);
               if (node.left != null) stack2.push(node.left);
               if (node.right != null) stack2.push(node.right);
           }
           if (!res.isEmpty()) {
               result.add(new ArrayList<>(res));
               res = new ArrayList<>();
           }
           while (!stack2.isEmpty()){
               TreeNode node = stack2.pop();
               res.add(node.val);
               if (node.right != null) stack1.push(node.right);
               if (node.left != null) stack1.push(node.left);
           }
           if (!res.isEmpty()) {
               result.add(new ArrayList<>(res));
               res = new ArrayList<>();
           }
       }

        return result;
    }


    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * 正常的按行遍历
     * 一个队列 + 两个指针last nlast
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer> > PrintByOrder(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode last = pRoot,nlast = pRoot;
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
        if (node.left != null) {
            queue.add(node.left);
            nlast = node.left;
        }
        if (node.right != null) {
            queue.add(node.right);
            nlast = node.right;
        }
        if (node == last) {
            result.add(new ArrayList<>(res));
            res = new ArrayList<>();
            last = nlast;
        }
        }
        return result;
    }
    @Test
    public void test() {
        TreeNode node = TreeNode.init();
        node.print();
        System.out.println(PrintByOrder(node));
    }
}
