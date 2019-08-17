package pratice;

import algorithm.leetcode.listnode.ListNode;
import algorithm.offerAlgorithm.treeProblem.TreeNode;
import jvm.memoryleak.Person;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:48 2019-03-26
 * @ Description：树的相关算法
 * @ Modified By：
 * @Version: $
 */
public class Demo2 {

    /**
     * 前序遍历
     * 中 左 右
     * @param node
     */
    public void firstTravel(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        firstTravel(node.left);
        firstTravel(node.right);
    }

    /**
     * 中序
     * 左中右
     * @param node
     */
    public void orderTravel(TreeNode node) {
        if (node == null) return;
        orderTravel(node.left);
        System.out.println(node.val);
        orderTravel(node.right);
    }

    /**
     * 后序
     * 左右中
     * @param node
     */
    public void lastTravel(TreeNode node) {
        if (node == null) return;
        lastTravel(node.left);
        lastTravel(node.right);
        System.out.println(node.val);
    }

    /**
     * 深度优先
     * 获取树的高
     * @param node
     */
    public int getDeep(TreeNode node) {
        if (node  == null) return 0;
        int deep1 = getDeep(node.left);
        int deep2 = getDeep(node.right);
        return Math.max(deep1,deep2) + 1;
    }

    /**
     * 广度优先，横向遍历
     * 横向遍历需要使用队列，记录每一行的每一个节点
     * @param node
     */
    public void crossTravel(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addFirst(node);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.removeLast();
            System.out.println(node1.val);
            if (node1.left != null) queue.addFirst(node1.left);
            if (node1.right != null) queue.addFirst(node1.right);
        }
    }

    /**
     * 还是逐行遍历
     * 但是每一行打一个换行
     * @param node
     */
    public void crossTravelSplit(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(node);
        TreeNode last = node;
        TreeNode nextLast = node;
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.removeLast();
            System.out.print(node1.val);
            if (node1.left != null) {
                queue.addFirst(node1.left);
                nextLast = node1.left;
            }
            if (node1.right != null) {
                queue.addFirst(node1.right);
                nextLast = node1.right;
            }
            if (node1 == last) {
                System.out.println();//换行
                last = nextLast;
            }
        }
    }

    /**
     * 前序遍历，只是采用二叉树的格式，返回一个TreeNode
     * 中左右
     * @param node
     */
    TreeNode result = new TreeNode(0);
    TreeNode res = result;
    public void firstTravelByTree1(TreeNode node) {
        if (node == null) return;
        result = result.right = new TreeNode(node.val);
        firstTravelByTree1(node.left);
        firstTravelByTree1(node.right);
    }
    public TreeNode firstTravelByTree(TreeNode root) {
        firstTravelByTree(root);
        return res.right;
    }

    /**
     * 获取到指定节点的路径
     * @param target
     * @param node
     * @return
     */
    public void getPath(TreeNode node,TreeNode target,ArrayList<TreeNode> arrayList) {
        if (node == null) return;
        arrayList.add(node);
        if (node == target) {
            return;
        }
        getPath(node.left,target,arrayList);
        getPath(node.right,target,arrayList);
        arrayList.remove(arrayList.size()-1);
    }

    /**
     * 获取两个元素的最近公共祖先
     * 首先获取两个路径，然后从头到尾遍历，找不一样的
     *
     * 怎么找，可以获取长度差之后，从尾部开始找一样的
     *
     * @param node1
     * @param node2
     */
    public TreeNode getNearstParent(TreeNode node1,TreeNode node2,TreeNode root) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        getPath(root,node1,path1);
        getPath(root,node2,path2);
        int length = Math.min(path1.size(),path2.size());
        for (int i = length; i >= 0; i--) {
            if (path1.get(i) == path2.get(i)) {
                return path1.get(i);
            }
        }
        return root;
    }

    /**
     * 获取所有根节点到叶节点和为target的路径
     *
     * 前序遍历
     * 中左右
     *
     * @param node
     * @param list
     * @param allList
     */
    public void getAllPathSum(TreeNode node,ArrayList<TreeNode> list,ArrayList<ArrayList<TreeNode>> allList,int target) {
        if (node == null) {
            if (target == 0) allList.add(new ArrayList<>(list));
            return;
        }
        list.add(node);
        getAllPathSum(node.left,list,allList,target-node.val);
        getAllPathSum(node.right,list,allList,target-node.val);
        list.remove(list.size()-1);
    }
    public ArrayList<ArrayList<TreeNode>> getAllPathSum(TreeNode root,int target) {
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
        getAllPathSum(root,new ArrayList<TreeNode>(),result,target);
        return result;
    }
}
