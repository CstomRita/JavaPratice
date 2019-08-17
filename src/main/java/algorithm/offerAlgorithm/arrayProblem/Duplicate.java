package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:27 2019-03-24
 * @ Description： 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * @ Modified By：
 * @Version: $
 */
public class Duplicate {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 思路一：使用HashSet，遍历一遍，时间复杂度O(n)
     *
     * @param numbers 输入数组
     * @param length 数组长度
     * @param duplication 长度为1的数组，将找到的重复元素赋值给[0]
     * @return 存在重复元素返回true，没有重复元素返回false
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if (numbers.length == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i : numbers) {
            if (set.contains(i)) {
                duplication[0] = i;
                return true;
            }else {
                set.add(i);
            }
        }
        return false;
    }

    /**
     * 注意审题，给定的数组元素是在 0 - length-1区间内的元素，数组长度为n
     * 这就表明如果没有重复元素的话，元素就是 0 - length-1 的所有元素
     * 那么按照元素的具体值作为下标去访问的话，应该正好访问一遍
     * 如果有重复的元素，那么就会有一个元素被访问两次
     *
     * 我们为重复元素标加上length，表示被访问过了
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0) return false;
        for (int i = 0; i < length; i++) {
            int index = numbers[i] % length;
            if (numbers[index] >= length) {
                duplication[0] =  index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }

    /**
     * 找出所有的重复元素
     * @param array
     */
    public ArrayList<Integer> duplicateAll(int array[]) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( array==null ) return result;
        for( int i = 0; i < array.length; i++ ){
            while( i!=array[i] ){
                if ( array[i] == array[array[i]] ) {
                    result.add(array[i]);
                    break;
                }
                int temp = array[i];
                array[i] = array[array[i]];
                array[temp] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
        return result;
    }

    /**
     * 非重复元素数组的排序
     * @param array
     */
    public void duplicateSort(int array[]) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( array==null ) return ;
        for( int i = 0; i < array.length; i++ ){
            while( i!=array[i] ){
                int temp = array[i];
                array[i] = array[array[i]];
                array[temp] = temp;
            }
        }
    }
    @Test
    public void test() {
        int[] du = new int[1];
        int[] num = new int[]{0,2,4,4,2,1,3};
       // duplicateSort(num);
        System.out.println(Arrays.toString(num));
        System.out.println(duplicateAll(num));
    }
}
