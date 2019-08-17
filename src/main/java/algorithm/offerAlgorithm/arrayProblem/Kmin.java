package algorithm.offerAlgorithm.arrayProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:15 2019-03-18
 * @ Description：输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @ Modified By：
 * @Version: $
 */
public class Kmin {

    /**
     * 暂定为包含重复元素
     * 思路一：排序之后找前K个数，排序O(nlogn)
     * 思路二：利用快排思想找第K小的算法，循环K次，KO(n),最大O(n^2)
     * 思路三：同样快排思想，但是这个过程中把K个找齐
     * 如果index小于K，则说明index左边的都是比K小的，left-index都应该在集合中，还有部分在index+1 - right中
     * 如果index大于K，则说明目标集合在left-index
     * 如果index == k，left-index收到集合中，返回
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k, int left, int right,ArrayList<Integer> res) {
        int temp = input[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && input[j] >= temp) j--;
            while (i < j && input[i] <= temp) i++;
            if (i >= j) break;
            int swap = input[i];
            input[i] = input[j];
            input[j] = swap;
        }
        input[left] = input[i];
        input[i] = temp;
        if (i < k) {
            for (int m = left; m <= i; m++) res.add(input[m]);
            GetLeastNumbers_Solution(input,k,i + 1, right,res);
        }else if (i > k) {
            GetLeastNumbers_Solution(input,k,left,  i - 1,res);
        }else{
            //i == k，left-部分添加，返回递归
            for (int m = left; m <= i; m++) res.add(input[m]);
        }
        return res;
    }

    /**
     * K-1是因为第K小的数的下标是K-1
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        if (k == input.length) {
            ArrayList<Integer> res = new ArrayList<Integer>(){{
                for(int i : input) add(i);
            }};
            return res;
        }
        // 要做一些参数的校验
        if ( k > input.length || k == 0||  input.length == 0) return new ArrayList<Integer>();
        return GetLeastNumbers_Solution(input,k-1,0,input.length-1,new ArrayList<Integer>());
    }

    @Test
    public void test() {
        System.out.println(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4));
    }
}
