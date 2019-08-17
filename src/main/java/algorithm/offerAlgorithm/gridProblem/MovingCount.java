package algorithm.offerAlgorithm.gridProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:13 2019-04-01
 * @ Description：地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * @ Modified By：
 * @Version: $
 */
public class MovingCount {


    /**
     * 回溯法 格子问题
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visted = new boolean[rows][cols];
        return movingCount(threshold,rows,cols,0,0,visted);
    }


    public int movingCount(int target,int rows,int cols,int rowIndex,int colIndex,boolean[][] visted) {
        if (colIndex < 0 || colIndex >= cols || rowIndex < 0 || rowIndex >= rows) return 0;
        if (visted[rowIndex][colIndex] || getNum(rowIndex,colIndex) > target) return 0;
        visted[rowIndex][colIndex] = true;
        int result = movingCount(target,rows,cols,rowIndex+1,colIndex,visted) +
                movingCount(target,rows,cols,rowIndex-1,colIndex,visted) +
                movingCount(target,rows,cols,rowIndex,colIndex-1,visted) +
                movingCount(target,rows,cols,rowIndex,colIndex+1,visted) + 1;
        return result;
    }

    private int getNum(int k,int m) {
        int result = 0;
        while (k != 0) {
            result += k % 10;
            k = k / 10;
        }
        while (m != 0) {
            result += m % 10;
            m = m / 10;
        }
        return result;
    }
}
