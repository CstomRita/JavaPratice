package algorithm.offerAlgorithm.treeProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:55 2019-03-20
 * @ Description： 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @ Modified By：
 * @Version: $
 */
public class TreeDepth {


    /**
     * 求深度，基本算法，记住
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int TreeDepth1(TreeNode root) {
        if (root == null) return 0;
        return TreeDepth1(root, 0);
    }

    private int TreeDepth1(TreeNode node, int deep) {
        if (node == null) {
            return deep;
        }
        return Math.max(TreeDepth1(node.left, deep + 1), TreeDepth1(node.right, deep + 1));
    }
}
