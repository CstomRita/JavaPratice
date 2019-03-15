package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:42 2019-03-12
 * @ Description： 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @ Modified By：
 * @Version: $
 */
public class PrintMatrix {


    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix == null) return arrayList;
        int startIndex = 0;
        int endIndex = matrix.length - 1;
        int startConlum = 0;
        int endConlum = matrix[0].length - 1;
        while (startConlum <= endConlum && startIndex <= endIndex) {
            for(int i = startConlum; i <= endConlum;i++) {
                arrayList.add(matrix[startIndex][i]);
            }

            for(int i = startIndex + 1; i <= endIndex; i++) {
                arrayList.add(matrix[i][endConlum]);
            }
            if (startIndex != endIndex) { //要考虑到只有一行和只有一列的情况
                for (int i = endConlum - 1; i >= startConlum; i--) {
                    arrayList.add(matrix[endIndex][i]);
                }
            }
            if (startConlum != endConlum) {
                for (int i = endIndex - 1; i >= startIndex + 1; i--) {
                    arrayList.add(matrix[i][startConlum]);
                }
            }
            startConlum++;
            startIndex++;
            endConlum--;
            endIndex--;
        }
        return arrayList;
    }

    @Test
    public void test() {
        System.out.println(printMatrix(new int[][]{
                {1,2,3,4}
        }));
    }
}
