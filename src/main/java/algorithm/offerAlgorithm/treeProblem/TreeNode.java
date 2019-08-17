package algorithm.offerAlgorithm.treeProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:03 2019-03-08
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        this.val = x;
    }

    public TreeNode(int x,TreeNode left,TreeNode right) {
        this.val = x;
        this.right = right;
        this.left = left;
    }
    /**
     * 二叉树的层次遍历只需使用一个队列即可，但若需要按层来换行打印则稍麻烦一些。
     *
     * 考虑到换行增加两个TreeNode：last和nlast
     * last：表示当前遍历层最右结点
     * nlast：表示下一层最右结点
     * 遍历时，每次将nlast指向插入队列元素，最后一个插入结点时即最右结点。插入左右孩子之后，检测last是否为当前输出结点，若是，则表示需要进行换行，并将last指向下一层的nlast。
     */
    public  void print() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this);
        TreeNode last = this;
        TreeNode nlast = this;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left != null) {
                queue.add(node.left);
                nlast = node.left;
            }
            if(node.right != null) {
                queue.add(node.right);
                nlast = node.right;
            }
            //以上就是逐行遍历了
            //下面做的是在每一行时加一个换行
            //什么时候换行，就是当当前节点是这一行最右边的元素时换行
            //那我们添加一个last标记，当这一行的last是最右边的时候，表示下一行也遍历完，用一个nlast去记录每一行的一个节点
            if(node == last) {
                System.out.println();
                last = nlast;
            }
        }

    }
    public static TreeNode init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(16, null, null);
        TreeNode G = new TreeNode(8, null, null);
        TreeNode F = new TreeNode(6, null, null);
        TreeNode E = new TreeNode(4, null, null);
        TreeNode D = new TreeNode(2, null, null);
        TreeNode C = new TreeNode(7, F, G);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(5, B, C);
        return A;   //返回根节点
    }

}
