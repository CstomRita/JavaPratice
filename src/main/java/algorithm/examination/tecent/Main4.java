package algorithm.examination.tecent;

import algorithm.binarytree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:24 2019-04-13
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main4 {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
       public void print() {
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();// n节点个数
            int[][] nums = new int[n-1][2];// 输入第一个是子节点，第二个父节点
            for (int i = 0; i < n-1; i++) {
              nums[i][0] = sc.nextInt();
              nums[i][1] = sc.nextInt();
            }
            TreeNode root = new TreeNode(1);
            getTree(nums,root);
            //root.print();
            System.out.println(getMinNumber(root));
        }
    }

    public static void  getTree(int[][] nums,TreeNode root) {
        // 输入第一个是子节点，第二个父节点
        if (root == null) return;
        for(int i = 0; i < nums.length;i++) {
            if (root.val == nums[i][1]) {
                if (root.left == null) {
                    root.left = new TreeNode(nums[i][0]);
                }else {
                    root.right = new TreeNode(nums[i][0]);
                }
            }
        }
        getTree(nums,root.left);
        getTree(nums,root.right);
    }

    public    static int getMinNumber( TreeNode root) {
       if (root.left == null && root.right == null) return 1;
       if (root.val == 1) {
           return Math.max(getMinNumber(root.left),getMinNumber(root.right));
       }
       if (root.left != null && root.right != null) {
           return getMinNumber(root.left) + getMinNumber(root.right) + 1;
       }else {
           if (root.left != null) {
               return getMinNumber(root.left)+1;
           }else {
               return getMinNumber(root.right)+1;
           }
       }
    }

}
