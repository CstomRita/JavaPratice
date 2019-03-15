package algorithm.offerAlgorithm.numberProblem;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:44 2019-03-10
 * @ Description：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @ Modified By：
 * @Version: $
 */
public class Numberof1 {
    /**
     * n % 2是获取这一位是0还是1
     * n / 2是获取前一位的数
     * 循环知道前一位数为0
     * 此上是正数的情况
     *
     * 如果是负数，要求用补码表示，补码为反码+1
     * 需要记录反码
     *
     *
     * 还需要注意的一点是，这里整数既然是Int表示的就要满足，int是32位的要求
     * 二进制表达都是32位，这对正数没有影响，但是对负数就要求，之前的未用到的位数都是1
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }
        int result = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (n != 0) {
            int index = n % 2;
            if (isNegative) {
                //这个步骤是为了取反码，如果0则写入1，如果1则写入0
                index = index == 0? 1 : 0;
                linkedList.addFirst(index);
            }
            if(index == 1 ) {
                result += 1;
            }
            n = n / 2;
        }
        if (isNegative) {
            result += 32 - linkedList.size();
            int number = 0;
            int index = linkedList.removeLast();
            while (index != 0) {
                number ++;
                index = linkedList.removeLast();
            }
            result = result - number + 1 ;
        }
        return result;
    }

    /**
     * 【思路一】
     * 借助与运算，通过和2的n-1次方做与运算判断是否为1
     * 循环次数32位，循环32次
     * 其中2的n-1次方可以借助左移完成，因为在32位中，所以不会溢出，而循环32次之后便会变为0，可以作为循环条件使用，不为0时循环
     * @param target
     * @return
     */
    public int numberof1Demo1(int target) {
        int result = 0;
        int res = 1;
        // res循环在32次
        while (res != 0) {
            if((res & target) != 0) {
                result++;
            }
            res = res << 1;
        }
        return result;
    }


    /**
     * 整数减去一之后，会将最右边的1变成0，1之后的0都变成1
     * 如果再和整数本身做与运算，会消除变成1的0
     * 由此总结：一个整数减去1，再和原来整数做与运算，会将最右边1变为0
     *
     * 那么二进制中有多少个1，我们就可以做多少次(n-1) & n的操作
     * 直至结果为0
     * @return
     */
    public int NumberOf1Demo2(int target) {
        int res = target;
        int result = 0;
        while (res != 0) {
            res = (res - 1) & res;
            result++;
        }
        return result;
    }
    @Test
    public void test() {
        System.out.println(NumberOf1(-1));
    }
}
