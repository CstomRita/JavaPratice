package algorithm.offerAlgorithm.treeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:32 2019-03-13
 * @ Description：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @ Modified By：
 * @Version: $
 */
public class PrintFromTopToBottom {

    /**
     * 二叉树的逐级遍历
     * 使用队列
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    /**
     * 从上向下层级 + 区分每一行
     * 再加两个节点区分行
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottomByRow(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode last = root;
        TreeNode nlast = root;
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nlast = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nlast = node.right;
            }
            if (node == last) {
                // dosomething
                last = nlast;
            }
        }
        return result;
    }
}
