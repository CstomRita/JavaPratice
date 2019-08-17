package algorithm.examination.tecent;

import algorithm.offerAlgorithm.treeProblem.TreeNode;
import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:25 2019-03-09
 * @ Description：腾讯笔试
 * @ Modified By：
 * @Version: $
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        System.out.println(isSearchTree(creatTreeNode(s)));
    }

    static TreeNode creatTreeNode(String[] res) {
        if (res.length <= 0) {
            return null;
        }
        TreeNode[] NodeArray = new TreeNode[res.length];

        for (int i = 0; i < res.length; i++) {
                if (NodeArray[i] == null) NodeArray[i] = new TreeNode(Integer.valueOf(res[i]));
                int idx = 2 * i + 1;
                if (idx <= res.length - 1) {
                    NodeArray[idx] = new TreeNode(Integer.valueOf(res[idx]));
                    NodeArray[i].left = NodeArray[idx];
                } else {
                    NodeArray[i].left = null;
                }
                idx++;
            if (idx <= res.length - 1) {
                NodeArray[idx] = new TreeNode(Integer.valueOf(res[idx]));
                NodeArray[i].right = NodeArray[idx];
            } else {
                NodeArray[i].right = null;
            }
        }
        return NodeArray[0];
    }



    public static boolean isSearchTree(TreeNode node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        return node.val >= node.left.val && node.val <= node.right.val && isSearchTree(node.left) && isSearchTree(node.right);
    }



}
