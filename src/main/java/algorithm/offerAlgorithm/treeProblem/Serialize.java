package algorithm.offerAlgorithm.treeProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:37 2019-03-30
 * @ Description：二叉树的序列化
 *请实现两个函数，分别用来序列化和反序列化二叉树
 * 基本算法 记住
 * @ Modified By：
 * @Version: $
 */
public class Serialize {

    /**
     * 前序遍历的序列化
     * 对于叶节点，没有左右孩子的也要设置两个#
     * 即要和Treenode的left 和 right取值是一样(叶节点的left right都是空 而不是没有)
     * 这才是二叉树的序列化
     * @param root
     * @return
     */
    StringBuilder Serialize1(TreeNode root) {
        if (root == null) return new StringBuilder("#,");
          return new StringBuilder().append(root.val).append(",").append(Serialize1(root.left)).append(Serialize1(root.right));
    }
    String Serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder s = Serialize1(root);
        s.deleteCharAt(s.length()-1);
        return s.toString();
    }

    /**
     * 前序遍历的反序列化
     * 中间元素拿出来，如果遇到数就是此节点的左孩子
     * 如果遇到# 则表示左孩子已经完毕，设置为null，该递归右孩子
     *
     * 采用一个队列，每次poll，不需要再维护数组的start end下标了
     *
     * @param queue
     * @return
     */
    TreeNode Deserialize(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        String s = queue.poll();
        if (s.equals("#")) {
            return null;
        }else {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = Deserialize(queue);
            node.right = Deserialize(queue);
            return node;
        }
    }
    TreeNode Deserialize(String str) {
        if (str.length() == 0 || str.equals("#")) return null;
        String[] chars = str.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(chars));
        return Deserialize(queue);
    }

    @Test
    public void test() {
        TreeNode node = TreeNode.init();
        node.print();
        String  s = (Serialize(node));
        Deserialize(s).print();
    }
}
