package algorithm.offerAlgorithm.treeProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:10 2019-03-29
 * @ Description：请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @ Modified By：
 * @Version: $
 */
public class IsSymmetrical {

    /**
     * 这个思路蛮好的，好好想一想怎么用递归的
     * 对称：一个节点.left = 兄弟节点.right
     * 一个节点.right = 兄弟节点.left
     * @param left
     * @return
     */
    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if ((left == null) ^ (right == null)) return false;//异或，只有一个为null
        return (left.val == right.val) && isSymmetrical(left.right,right.left) && isSymmetrical(left.left,right.right);
    }
    boolean isSymmetrical(TreeNode head){
        if (head == null) return true;
        return isSymmetrical(head.left,head.right);
    }
}
