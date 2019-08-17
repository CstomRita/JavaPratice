package algorithm.sortalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:29 2019-08-16
 * @ Description：排列组合问题
 * @ Modified By：
 * @Version: $
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(combine(new int[]{1,2,3,4,5},3));
    }

    /**
     * @Author: ChangSiteng
     * @Description: 组合算法，就是从N个里面选择M个，不涉及M个的排序问题
     *  组合算法
     *     // 本程序的思路是开一个数组，其下标表示1到m个数，
     *     数组元素的值为1表示其下标代表的数被选中，为0则没选中。
     *     1. 首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。
     *     2. 然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为“01”组合
     *          同时将这个"01"组合左边的所有“1”全部移动到数组的最左端。
     *     3. 直到数组的m-n位置上才会出现第一个1时，也就是n个“1”全部移动到最右端时，就得到了最后一个组合。
     *     // 例如求5中选3的组合：
     *     // 1 1 1 0 0 //1,2,3
     *     // 1 1 0 1 0 //1,2,4
     *     // 1 0 1 1 0 //1,3,4
     *     // 0 1 1 1 0 //2,3,4
     *     // 1 1 0 0 1 //1,2,5
     *     // 1 0 1 0 1 //1,3,5
     *     // 0 1 1 0 1 //2,3,5
     *     // 1 0 0 1 1 //1,4,5
     *     // 0 1 0 1 1 //2,4,5
     *     // 0 0 1 1 1 //3,4,5
     * @param number:
     * @return: java.util.List
     */
    public static List combine(int[] number,int m) {
        ArrayList list = new ArrayList();
        // 1 初始化一个数组
        int[] indexs = new int[number.length];
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < m; i++) {
            indexs[i] = 1;
            s.append(number[i]).append(" ");
        }
        list.add(String.valueOf(s));

        //2 从左到右扫描 10 组合
        // 循环次数的依据为第一个1出现在n-m位置上
        int firstOne = 0;
        int changeIndex = 0;
        while (firstOne < (indexs.length-m)) {
            // 2.1扫描10 组合交换
            for (int i = 0; i < indexs.length - 1; i++) {
                if (indexs[i] == 1 && indexs[i+1] == 0) {
                    changeIndex = i;
                    int temp = indexs[i];
                    indexs[i] = indexs[i+1];
                    indexs[i+1] = temp;
                    break;
                }

            }
            // 2.2 将10组合左边的1（index < changeIndex） 移动至最左边
            // 如何移动，就看左边有多少一，在给数组重新赋值
            int sum = 0;
            for (int i = 0; i < changeIndex; i++) {
                sum += indexs[i];
            }
            System.out.println(Arrays.toString(indexs)+"======"+changeIndex + "--------"+sum);
            for (int i = 0; i < changeIndex; i++) {
                if (sum > 0) {
                    indexs[i] = 1;
                    sum--;
                }else {
                    indexs[i] = 0;
                }
            }

            // 2.3 扫描此时第一个1，给firstOne赋值
            // 同时为list添加此次的结果
            boolean first = true;
            s = new StringBuffer();
            for (int i = 0; i < indexs.length; i++) {
                if (first && indexs[i] == 1) {
                    firstOne = i;
                    first = false;
                    s.append(number[i]).append(" ");
                }else if (indexs[i] == 1) {
                    s.append(number[i]).append(" ");
                }
            }
            list.add(String.valueOf(s));
        }

        return list;
    }


}
