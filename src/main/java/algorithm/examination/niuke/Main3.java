package algorithm.examination.niuke;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:53 2019-04-24
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < num; i++) {
                int m = in.nextInt();
                if (hashMap.containsKey(m)) {
                    hashMap.put(m, hashMap.get(m) + 1);
                } else {
                    hashMap.put(m, 1);
                }
            }
            ArrayList<Integer> values = new ArrayList<>(hashMap.values());
            int count = 0;
            for (int i = 2; i < values.size(); i++) {
                count = getMax(getMax(values.get(i-2), values.get(i-1)), values.get(i));
            }
            if (count < 2) {
                System.out.println(0);
            }else {
                int sum = 0;
                for (Integer i : values) {
                    sum += i/count;
                }
                System.out.println(sum);
            }
        }
    }

    /**
     * 求最大公约
     * @param a
     * @param b
     * @return
     */
    public static int getMax(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
