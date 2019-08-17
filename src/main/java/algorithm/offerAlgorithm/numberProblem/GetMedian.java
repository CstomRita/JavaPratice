package algorithm.offerAlgorithm.numberProblem;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:10 2019-03-30
 * @ Description：获取中位数
 *
 如何得到一个数据流中的中位数？
 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @ Modified By：
 * @Version: $
 */
public class GetMedian {

    /**
     * 维护一个有序数组，num例如插入排序，那么一次插入时间复杂度为O(n)
     * 选择用什么维护有序数组，利用数组则需要考虑数组的扩容问题，ArrayList本质上也是数组，只是在数组上封装
     * 获取中位数，复杂度为O(1)
     * @param num
     */
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public void Insert(Integer num) {
        for(int i = 0; i < arrayList.size(); i++) {
            if (num > arrayList.get(i)) {
                arrayList.add(i,num);
                return;
            }
        }
        arrayList.add(num);
    }

    public Double GetMedian() {
        int size = arrayList.size();
        int index = size / 2;
        return size % 2 == 0 ? (double)((arrayList.get(index)) + arrayList.get(index-1)) / 2 : (double)arrayList.get(index);

    }

    @Test
    public void test() {
        Insert(2);
        Insert(8);
        Insert(2);
        Insert(0);
        Insert(4);
        System.out.println(arrayList);
        System.out.println(GetMedian());
    }

}
