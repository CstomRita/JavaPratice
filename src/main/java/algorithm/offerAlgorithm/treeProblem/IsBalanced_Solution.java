package algorithm.offerAlgorithm.treeProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:32 2019-03-20
 * @ Description：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @ Modified By：
 * @Version: $
 */
public class IsBalanced_Solution {

    /**
     * 平衡二叉搜索树，又被称为AVL树，且具有以下性质：
     * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        try {
            IsBalanced_Solution1(root);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public int IsBalanced_Solution1(TreeNode root) throws Exception {
        if (root == null) return 0;
        int leftDepth = IsBalanced_Solution1(root.left);
        int rightDepth = IsBalanced_Solution1(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            throw new Exception();
        }else{
            return Math.max(leftDepth,rightDepth) + 1;
        }
    }
}
