package algorithm.offerAlgorithm.treeProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:31 2019-03-12
 * @ Description：操作给定的二叉树，将其变换为源二叉树的镜像。
 * @ Modified By：
 * @Version: $
 */
public class Mirror {
    /**
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     */

    /**
     * 还是用递归，左右子树互换
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode nodeLeft = root.left;
        TreeNode nodeRight = root.right;
        root.right = nodeLeft;
        root.left = nodeRight;
        Mirror(nodeLeft);
        Mirror(nodeRight);
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(11);
        node.print();
        Mirror(node);
        node.print();
    }
}
