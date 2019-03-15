package algorithm.offerAlgorithm.treeProblem;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:04 2019-03-08
 * @ Description：重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @ Modified By：
 * @Version: $
 */
public class ReConstructBinaryTree {
    private int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree1(0,in.length-1,pre,in);
    }

    /**
     * 优化后的递归函数
     * 不需要拆分数组，使用下标代替
     * 拆分数组时，尽量先看是否能用start、end下标表示，尽量不真的拆数组
     * @param inStartIndex
     * @param inEndIndex
     * @param pre
     * @param in
     * @return
     */
    private TreeNode reConstructBinaryTree1(int inStartIndex, int inEndIndex, int[] pre, int[] in) {
        if (index >= pre.length || inStartIndex > inEndIndex) return null;
        int num = pre[index++];
        TreeNode node = new TreeNode(num);
        for(int i = inStartIndex; i <= inEndIndex; i++) {
            if(in[i] == num) {
                //start i-1是左，i+1 end是右边
                node.left = reConstructBinaryTree1(inStartIndex, i - 1,pre,in);
                node.right = reConstructBinaryTree1(i + 1, inEndIndex, pre, in);
                //找到之后没有必要再遍历了
                break;
            }
        }
        return node;
    }


    private void reConstructBinaryTree(TreeNode node , boolean isLeft, int[] array, int [] pre) {
        if(array == null || array.length == 0 || index >= pre.length) return;
        int num = pre[index++];
        if(isLeft) {
            node.left = new TreeNode(num);
            node = node.left;
        }else {
            node.right = new TreeNode(num);
            node = node.right;
        }
        int[][] res = splitArray(num,array);
        int[] left = res[0];
        System.out.println(Arrays.toString(left));
        int[] right = res[1];
        System.out.println(Arrays.toString(right));
        reConstructBinaryTree(node,true,left,pre);
        reConstructBinaryTree(node,false,right,pre);
    }

    /**
     * 拆分数组，过于繁琐，是否有可优化方式？？？
     * 未重复数组，按照某一个元素拆分左右两个部分
     * @param num
     * @param array
     * @return
     */
    private int[][]  splitArray(int num, int[] array) {
       int[][] result = new int[2][];
       ArrayList arrs = new ArrayList();
        boolean isLeft = true;
        int index = 0;
        for(int arr : array) {
            if (arr == num) {
                isLeft = false;
                result[0] = new int[index];
                for(int i = 0; i < index; i++) {
                    result[0][i] = (int) arrs.get(i);
                }
                arrs.clear();
                index = 0;
            }else if(isLeft) {
                index++;
                arrs.add(arr);
            }else {
                index++;
               arrs.add(arr);
            }
        }
        result[1] = new int[index];
        for(int i = 0; i < index; i++) {
            result[1][i] = (int) arrs.get(i);
        }
        return result;
    }

    @Test
    public void test() {
        reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6}).print();
    }
}
