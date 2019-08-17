package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:38 2019-03-30
 * @ Description：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * @ Modified By：
 * @Version: $
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length == 0 || size == 0) return result;
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < num.length; i++) {
            int index = (i-size+1);
            // 1 旧元素是否已经滑出
            if (!queue.isEmpty() && queue.peekFirst() < index) {
                //说明最大值窗口已经滑出
                queue.removeFirst();
            }

            // 2 小于新元素的删除 + 添加新元素
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.removeLast();
            }
            queue.addLast(i);

            // 3 获取最大值，就是First，此时需要注意的一点
            // 滑动窗口和队列的唯一不同，滑动窗口内元素的个数是一定的，因此在下标0-zise-1之间是没有所谓的窗口的
            if (index >= 0) result.add(num[queue.peekFirst()]);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(maxInWindows(new int[]{2,3,4,2,6,2,5,1},3));
    }
}
