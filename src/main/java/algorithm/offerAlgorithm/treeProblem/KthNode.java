package algorithm.offerAlgorithm.treeProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:32 2019-03-30
 * @ Description：给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @ Modified By：
 * @Version: $
 */
public class KthNode {
    /**
     * 二叉搜索树，是 左 < 中 < 右的
     * 按照中序遍历，即使从小到大遍历
     * 所有操作只需要考虑node一个节点即可，其他的不必考虑
     * 设置经过左边递归回来之后已经有个计数值target了
     * 只需要将本节点node的计数加一即可
     *
     *
     * 递归就是只需要考虑本次一个节点
     * 其他默认是完成好的
     *
     *
     * @param node
     * @return
     */
    int target = 0;
    TreeNode KthNode(TreeNode node,int k){
       if (node == null) return null;
       TreeNode node1 = null;
       node1 = KthNode(node.left,k);
       if (node1 != null) return node1;

       target++;
       if (target == k) return node;

       node1 = KthNode(node.right,k);
       return node1;
    }

    @Test
    public void test() {
        TreeNode node = TreeNode.init();
        node.print();
        System.out.println(KthNode(node,6).val);
    }
}
