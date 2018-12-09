package algorithm.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:17 2018/11/3
 * @ Description：二叉树遍历
 * @ Modified By：
 * @Version: $
 */
public class Traversal {
    private TreeNode root = TreeNode.init();

    /**
     * 前序遍历
     * 父 左 右
     */
    @Test
    public void firstTraversal() {
        firstTraversal(root);
    }
    private void firstTraversal(TreeNode node) {
        if(node == null) return;
        System.out.print(node.element);
        firstTraversal(node.left);
        firstTraversal(node.right);
    }

    /**
     * 中序遍历
     * 左 父 右
     */
    @Test
    public void orderTraversal() {
        orderTraversal(root);
    }
    private void orderTraversal(TreeNode node) {
        if(node == null) return;
        orderTraversal(node.left);
        System.out.print(node.element);
        orderTraversal(node.right);
    }

    /**
     * 后序遍历
     * 左 右 父
     */
    @Test
    public void lastTraversal() {
        lastTraversal(root);
    }
    private void lastTraversal(TreeNode node) {
        if(node == null) return;
        lastTraversal(node.left);
        lastTraversal(node.right);
        System.out.print(node.element);
    }

    /**
     * 面试题目1
     * 二叉树前序遍历 生成一个链表
     * 这个链表依然使用二叉树的数据格式 ，只是左子树全部为 null而已
     *
     * 第一次的错误：
     * 直接
     *  getByFirst(node.left,result.right);
     *  getByFirst(node.right,result.right);
     *  错误原因：left递归完成之后的开始right递归的result是一样的，这就会导致right递归之后的结果会覆盖掉之前的结果
     *  是错误的
     *  应该递归回来之后还是继续result
     *  要么定义一个类成员变量，每次都能.right
     *  要么left完成之后再while循环查找到最后的一个节点
     */
    TreeNode result = new TreeNode(0,null,null);
    @Test
    public void getByFirst() {
        TreeNode resultlist = result;
        getByFirst(root);
        resultlist.right.print();
    }
    private void getByFirst(TreeNode node) {
        if(node == null) return;
        result.right = new TreeNode(node.element,null,null);
        result = result.right;
        getByFirst(node.left);
//        while (result.right != null){
//            result = result.right;
//        }
        getByFirst(node.right);
    }

    /**
     * 题目2：查找二叉树根节点到某一个指定节点的路径
     * 非常重要
     * 前序遍历
     * 需要的注意的是在递归方法完成时说明左右子树都没有发现
     * 需要删除掉当前list的最后一个，也就是当前递归的当前节点
     * 表示返回到父节点
     *
     * PPS 你看这里list是可以传递的，是因为每次list.add都是在最后一个元素上add
     * 但是上面那个target指向的是一个节点，在递归返回时会指向的是递归时的那个节点，并不是最后一个，所以传递上有问题
     */
    @Test
    public void getPath() {
        List<TreeNode> path = new ArrayList<TreeNode>();
        try {
            getPath(root,root.right.left,path);
        } catch (Exception e) {
            for(TreeNode node : path) {
                System.out.print(node.element+" ");
            }
        }
    }

    private void getPath(TreeNode node, TreeNode target, List<TreeNode> path) throws Exception{
        if(node == null) return;
        path.add(node);
        if(node == target) throw new Exception();
        // return 只会返回一次函数，后面的getPath依然会运行，虽然最后也会因为找不到target remove掉
        // 但是实际上是遍历了所有的路径来找这个target
        // 如果想找到这个target的时候跳出所有的递归，需要使用抛异常的方式
        // 再去catch处理
        getPath(node.left,target,path);
        getPath(node.right,target,path);
        path.remove(path.size() - 1);
    }

    /**
     * 题目三：寻找两个节点的最近公共祖先
     * 上面那个寻找路径的很重要
     * 很多问题都可能用到这个基础
     * 比如这个最近公共祖先，可以分别拿到各自的路径，然后从下标0开始比对，当下一个不相等时，当前这个就是最大公共祖先
     *
     * 如果两者是一个节点 返回node1
     * 如果两者不是一个节点 那么路径的最后一个元素必然不相等 没有比较的必要
     */
    @Test
    public void getNearestParent() {
        TreeNode node1 = root;
        TreeNode node2 = root;
        System.out.println(node1.element + " "+ node2.element);
        TreeNode neatestParent = getNearestParent(node1,node2);
        System.out.println(neatestParent.element);
    }
    private TreeNode  getNearestParent(TreeNode node1 , TreeNode node2) {

        if(node1 == node2) return node1;
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        try {
            getPath(root,node1,path1);

        } catch (Exception e) {
            try {
                getPath(root,node2,path2);
            } catch (Exception e1) {
            }
        }
        System.out.println(path1);
        System.out.println(path2);
        int length = Math.min(path1.size(),path2.size());
        for(int i = 0; i < length - 1; i++) {
            if(path1.get(i+1) != path2.get(i+1)) {
                return path1.get(i);
            }
        }
        return null;
    }

    /**
     * 题目4: 从根节点到叶节点输出所有路径元素和为N的路径
     */
    @Test
    public void getSum() {
        List<TreeNode> currentPath = new ArrayList<TreeNode>();
        List<List<TreeNode>> allPath = new ArrayList<List<TreeNode>>();
        getSum(30,currentPath,root,allPath);
        System.out.println(allPath);
        for(List<TreeNode> list : allPath) {
            for(TreeNode node : list) {
                System.out.print(node.element + "   ");
            }
            System.out.println();
        }
    }
    private void getSum(Integer target,List<TreeNode> currentPath, TreeNode node,List<List<TreeNode>> allPath) {

        if(node == null) return;
        currentPath.add(node);
        if(node.left == null && node.right == null && node.element == target) {
            List<TreeNode> path = new ArrayList<TreeNode>(currentPath);
            allPath.add(path);
            //这里不要写return
            //如果写了return就不能执行下面 currentPath.remove(currentPath.size() - 1);这个是删除当前的节点
            //这样找到一个路径return 就不会删除这个元素 导致路径中多了一个元素
        }
        getSum(target-(Integer) node.element,currentPath,node.left,allPath);
        getSum(target-(Integer) node.element,currentPath,node.right,allPath);
        currentPath.remove(currentPath.size() - 1);
    }
}
