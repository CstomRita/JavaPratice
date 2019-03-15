package algorithm.offerAlgorithm.treeProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:24 2019-03-12
 * @ Description：输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * @ Modified By：
 * @Version: $
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return HasSubtree1(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    /**
     * 首先比较根节点是否相等 中 左 右 这样的前序遍历
     * 递归实现
     * @param root1
     * @param root2
     * @return
     */
    private boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        /**
         * 注意递归出口
         */
        if (root1 == null && root2 != null) return false;
        if (root2 == null ) return true;
        // 剩下的是root1和root2都不为null的情况
        // 根节点相等,分析这个根节点的left和right
        if (root1.val == root2.val) {
           return HasSubtree1(root1.left,root2.left) && HasSubtree1(root1.right,root2.right);
        }else {
            //如果根节点不相等
           return false;
        }
    }

}
