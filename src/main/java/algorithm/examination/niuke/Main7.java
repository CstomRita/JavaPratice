package algorithm.examination.niuke;

import java.util.*;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:33 2019-08-31
 * @ Description： 寻找子串的最大出现次数
 * @ Modified By：
 * @Version: $
 */
public class Main7 {

    static int max = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            getResult(s);
            System.out.println(max);
        }
    }
    private static void getResult(String s) {
        char[] chars = s.toCharArray();
        HashMap<String,Integer> hashMap = new HashMap<>();
        Stack stack = new Stack();
        for (int i = 1; i <= chars.length;i++) {
            int[] used = new int[chars.length];
            rank(chars,used,i,0,hashMap,stack);
        }
    }

    /**
     * @Author: ChangSiteng
     * @Description: 从chars选择n个作为子字符串，k已经选定了k个
     * @return: void
     * used数组表示是否使用过
     */
    private static void rank(char[] chars, int[] used, int n, int k, HashMap<String,Integer> hashMap, Stack stack) {

        if( n == k) {
            String result = Arrays.toString(stack.toArray());
            int count = 0;
            if (hashMap.containsKey(result)) {
                count = hashMap.get(result) ;
            }
            hashMap.put(result,count+1);
            max = Math.max(max,count+1);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                stack.push(chars[i]);
                rank(chars,used,n,k+1,hashMap,stack);
                used[i] = 0;
                stack.pop();
            }
        }
    }
}
