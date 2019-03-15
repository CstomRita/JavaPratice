package algorithm.offerAlgorithm.treeProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:37 2019-03-13
 * @ Description： 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * @ Modified By：
 * @Version: $
 */
public class VerifySquenceOfBST {

    /**
     * 注意题目是二叉搜索树
     * 二叉搜索树：
     * 后序：左 右 中
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false; //空树也是二叉搜索树
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    /**
     * 递归循环 从 start 到 end
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence, int start,int end) {
        if (start < 0 || start >= end || end >= sequence.length) return true;
        int root = sequence[end];
        int index = end - 1;
        boolean findRightIndex = false;
        for (int i = start; i < end; i++) {
          if (!findRightIndex && sequence[i] > root) {
              index = i;
              findRightIndex = true;
          }
          if (findRightIndex && sequence[i] < root) {
              return false;
          }
        }
        return VerifySquenceOfBST(sequence,start,index - 1) && VerifySquenceOfBST(sequence, index, end - 1);
    }

    @Test
    public void test() {
        System.out.println(VerifySquenceOfBST(new int[]{2,4,3,5,6,5,4}));
    }
}
