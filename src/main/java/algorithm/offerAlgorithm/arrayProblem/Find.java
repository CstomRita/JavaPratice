package algorithm.offerAlgorithm.arrayProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 08:59 2019-03-08
 * @ Description：二维数组的查找
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @ Modified By：
 * @Version: $
 */
public class Find {
    public boolean Find(int target, int [][] array) {
        if (array.length == 0) return false;
        int row = array.length;// 行数
        int indexRow = 0;
        int conlum = array[0].length;// 列数
        int indeConlum = conlum - 1;
        while (indexRow < row && indeConlum >= 0) {
            int num = array[indexRow][indeConlum];
            if(num > target) {
                indeConlum -= 1;
            }else if (num < target) {
                indexRow += 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
