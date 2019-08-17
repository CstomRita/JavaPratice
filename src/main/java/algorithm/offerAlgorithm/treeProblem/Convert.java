package algorithm.offerAlgorithm.treeProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:15 2019-03-15
 * @ Description：输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @ Modified By：
 * @Version: $
 */
public class Convert {

    TreeNode list = null;

    /**
     * 1 二叉树的中序遍历就是递增的序列
     * 2 如果想把二叉树变成一个链表，需要构建成只有左子树或者右子树的二叉树，这样才能是一个链表
     * 3 要求不能创建其他新的节点,需要找到最小的那个递归出口，作为首节点
     * @param node
     * @return
     */
    public TreeNode Convert(TreeNode node) {
        if (node == null) return null;
        list = Convert(node.left);
        list.right = node;
        list = list.right;
        return null;
    }


}
