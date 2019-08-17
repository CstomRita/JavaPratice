package algorithm.offerAlgorithm.gridProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:20 2019-04-01
 *
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 但是矩阵中不包含"abcb"路径，
 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class StringHasPath {

    /**
     * 很明显走格子的算法，上下左右，需要使用回溯法
     * 所谓回溯法，就是递归实现的
     * 前n-1个元素已经找到，目前找第n个元素
     * 现在设置rowIndex colIndex就是第n个元素，如果符合条件继续探索
     * 如果不符合条件，则跳回到上面第n-1个元素
     * 至于如何回到n-1元素，一般采用形参的形式，但是如果采用了list或者数组等方式就需要remove了
     * 回到n-1元素，要还原没有经历这个元素之前的样子，尤其涉及到数组改变的，要做判断
     * 是否需要将数组还原
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (str.length == 0) return false;
        boolean[] visted = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix,i,j,0,str,rows,cols,visted)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath(char[] matrix,int rowIndex,int colIndex,int n, char[] str,int rows,int cols,boolean[] visted) {
        //是否符合基本条件,是否越过二维数组的格子
        if (rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols) return false;
       // 是否访问过，是否等于该元素
        int index = rowIndex * cols + colIndex;
        char c = str[n];
        if (visted[index] || matrix[index] != c) return false;
        // 以下为此元素符合第n位元素下的操作
        visted[index] = true;
        if (n == str.length-1) return true;
        if(hasPath(matrix,rowIndex+1,colIndex,n+1,str,rows,cols,visted)
                || hasPath(matrix,rowIndex,colIndex+1,n+1,str,rows,cols,visted)
                || hasPath(matrix,rowIndex,colIndex-1,n+1,str,rows,cols,visted)
                || hasPath(matrix,rowIndex-1,colIndex,n+1,str,rows,cols,visted)){
            return true;
        }
        // 这一部分是回溯法回溯的部分，要充分考虑到如果当前路线不可行时，要将所有数据还原成没有走这个路线的情况
        // 尤其是数组、list等不根据形参改变的元素，要充分考虑
        visted[index] = false;
        return false;
    }

    @Test
    public void  test() {
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));
    }
}
