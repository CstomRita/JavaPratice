package algorithm.offerAlgorithm.numberProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:44 2019-03-23
 * @ Description： 一些简单的操作，但是不允许使用一些方法
 * @ Modified By：
 * @Version: $
 */
public class SampleSolutionWithLimit {

    /**
     * 求1+2+3+...+n，
     *  * 要求不能使用乘除法、
     *  * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * 不能使用乘除法，那么能使用的有：
     * 单目运算符：++和--,
     * 双目运算符：+,-，
     * 移位运算符<<和>>，
     * 关系运算符>,<等，
     * 逻辑运算符&&，||,&,|,^，
     * 赋值=
     *
     *
     * 同时不能使用循环、判断等等
     * 对于要实现循环功能的，禁止循环之后只能使用递归
     * 但是递归还需要If判断递归出口，如果不能使用If的话，还有什么方法可以实现递归出口
     * 逻辑运算符具有的短路特性：前面的条件判真（或者假）了，就不会再执行后面的条件了，此时可以通过这个方法实现递归出口
     *
     *
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n; // 这里 n ，下次递归就是 n -1 ，如此相加 n + n-1 + n-2 ...
        boolean flag = n > 0 && (sum += Sum_Solution(n-1)) > 0;
        return sum;
    }


    /**
     *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     *
     * 不得使用加减乘除的话，还有移位、关系、逻辑、赋值运算符
     *
     * 明显应该是采用按照二进制位采用逻辑或者移位的方法
     * 以二进制的方式相加
     *
     * 二进制相加的方式：
     * 1. 首先查看哪些位数上是有两个1的，即 n1 & n2为1的位数，这些位数相加是需要进位的
     * n1 & n2的结果即为所有需要进一位的位数，左移移位来进位。
     * 2. 查看哪些位数上只有一个1的，即采用异或的方式，^，这些位数直接相加即可
     * n1 ^ n2 的结果即为直接相加的位数相得的数
     *
     * 具体的输出结果是 n1 && n2 + n1 ^ n2的值
     * 如何相加，依照上面的方式再次循环
     * 知道n1 或 n2中有一个为0
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int temp1 = 0, temp2 = 0;
        while (num1 != 0) {
            temp1 = (num1 & num2) << 1;
            temp2 = num1 ^ num2;
            num1 = temp1;
            num2 = temp2;
        }
        return num2;
    }


    @Test
    public void test() {
        System.out.println(Sum_Solution(4));
        System.out.println(Add(18,30));
    }
}
