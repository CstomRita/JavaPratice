package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 20:12 2019-03-18
 * @ Description：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 *
 * @ Modified By：
 * @Version: $
 */
public class PrintMinNumber {
    private String result = null;
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0) return "";
        PrintMinNumber(numbers,0);
        return result;
    }

    /**
     * 思路一：类似于之前的a b c回溯法全排列，然后其中选择最小的一个。
     *
     * 需要注意的问题是：要考虑到Integer溢出的问题，也正是因为如此返回值采用了string类型
     *
     * @param numbers
     * @param index
     * @return
     */
    public void PrintMinNumber(int [] numbers,int index) {
        if (index == numbers.length-1) {
            //最后元素
            StringBuffer stringBuffer = new StringBuffer();
            for (int i : numbers) stringBuffer.append(i);
            if (result != null) {
                result = result.compareTo(stringBuffer.toString()) < 0 ? result : stringBuffer.toString();
            }else {
                result = stringBuffer.toString();
            }
        }else {
            //开始回溯,交换+递归+交换

            for (int i = index; i < numbers.length; i++) {
                int temp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = temp;

                PrintMinNumber(numbers,index+1);

                temp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = temp;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(PrintMinNumber(new int[]{3334,3,3333332}));
    }
}
