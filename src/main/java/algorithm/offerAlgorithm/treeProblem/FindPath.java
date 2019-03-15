package algorithm.offerAlgorithm.treeProblem;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:33 2019-03-13
 * @ Description：输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @ Modified By：
 * @Version: $
 */
public class FindPath {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        findPath(root,target,new ArrayList<>());
        return result;
    }

    /**
     * 如何让数组长度大的靠前面
     * 再递归时先递归左右子树中不为空的那个
     * @param node
     * @param target
     * @return
     */
    private void findPath(TreeNode node,int target,ArrayList<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null &&  target == 0) { //路径是到叶节点，叶节点是没有左右孩子的节点，只有右孩子的节点不能称为叶节点
            //这条路可以
            result.add(new ArrayList<>(list));
        }
        if (node.left == null) {
            findPath(node.right,target,list);
            findPath(node.left, target, list);
        }else {
            findPath(node.left, target, list);
            findPath(node.right,target,list);
        }

        list.remove(list.size()-1);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        System.out.println(FindPath(root,2));
    }
}
