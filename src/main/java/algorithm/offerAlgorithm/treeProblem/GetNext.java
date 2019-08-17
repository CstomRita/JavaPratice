package algorithm.offerAlgorithm.treeProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:24 2019-03-29
 * @ Description：给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @ Modified By：
 * @Version: $
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; // 指向父节点的指针

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class GetNext {

    /**
     * 中序遍历，左 中 右
     * 一个节点在中序遍历中的下一个节点： 右 子节点的中序遍历
     * 如果没有右子节点，就是父节点的右子节点的中序遍历
     * 如此递归
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 右子树不为空时直接向下遍历即可
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            pNode = pNode.right.left;
            while (pNode != null) {
                if (pNode.left != null) {
                    pNode = pNode.left;
                }else if (pNode.right != null) {
                    pNode = pNode.right;
                }
                if (pNode.left == null && pNode.right == null) return pNode;
            }
            return node;
        }
        // 右子树为空时分为多种情况，如果该节点是父节点的左子节点，则直接返回父节点
        // 如果节点是右子节点，向上再次next,phead = phead.next，
        TreeLinkNode target = pNode;
        pNode = pNode.next;
        while (pNode != null) {
            if (pNode.left == target) return pNode;
            target = pNode;
            pNode = pNode.next;
        }
        return null;
    }
}
