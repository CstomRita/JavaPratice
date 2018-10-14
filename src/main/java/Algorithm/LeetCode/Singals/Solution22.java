package Algorithm.LeetCode.Singals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午8:55 2018/9/28
 * @ Description：成对的符号：括号、方框、大括号等等
 * @ Modified By：
 * @Version: $
 */
public class Solution22 {

    /**
     * leetcode 第22题
     *
     * @param n
     * @return
     */

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        return result;
    }

    private static void generateParenthesis(int n, StringBuilder stringBuilder,List<String> result,int k) {
        if (n == 1) {
            stringBuilder.append("()");
            return;
        }
        StringBuilder s = stringBuilder;

        stringBuilder.append("()");
        generateParenthesis(n - 1, stringBuilder,result,k);


        if(n == k){
            System.out.println(stringBuilder.toString());
        }



        stringBuilder.append("(");
        generateParenthesis(n - 1, stringBuilder,result,k);
        stringBuilder.append(")");
        if(n == k){
            System.out.println(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        }



    }

    public static void main(String[] args) {
        generateParenthesis(3,new StringBuilder(),new ArrayList<String>(),3);
    }
}
