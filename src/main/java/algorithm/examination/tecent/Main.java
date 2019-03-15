package algorithm.examination.tecent;


/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:58 2019-03-09
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int mod = (int) 2e5 ;
        System.out.println(mod);
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();  // n 张卡片
        int n = sc.nextInt();
        int[] sol = new int[n];
        for(int i = 0; i < n; i++){
                sol[i] = sc.nextInt();
        }
        System.out.println(getNumber1(m,n,sol));
    }

    /**
     * sol 连续n项中，都包含1-m
     * @param m
     * @param n
     * @param sol
     * @return
     */
    private static int getNumber1(int m,int n,int[] sol) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer max = 0;
        Integer min = 0;
        boolean flag = false;
        int result = n;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] == 0) {
                ArrayList<Integer> values = (ArrayList<Integer>) hashMap.values();
                if (values.size() == m) {
                    flag = true;
                    //表示完成了
                    for (Integer value : values) {
                        if (value < min) min = value;
                        if (value > max) max = value;
                        result = Math.min(max - min + 1, result);
                    }
                } else {
                    hashMap.clear();
                }
            } else {
                if (!hashMap.containsKey(sol[i])) {
                    hashMap.put(sol[i], i);
                }
            }
        }
        if (hashMap.values().size() == m) {
            ArrayList<Integer> values = (ArrayList<Integer>) hashMap.values();
            if (values.size() == m) {
                flag = true;
                //表示完成了
                for (Integer value : values) {
                    if (value < min) min = value;
                    if (value > max) max = value;
                    return (max - min + 1);
                }
            }
            result = Math.min(max-min+1,result);
        }
        System.out.println(flag);
        return flag? result : -1;
    }
    private static int getNumber(int n,int score,int[] card) {
        if (score > n) return 0;
        if (score == n) return 1;
        int[][] res = new int[n+1][score+1];
        res[1][0] = 2;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j<= score; j++) {
                if (i != 0 && j == 0) {
                    res[i][0] = 2 * res[i-1][0];
                }
                if(i == 0) res[0][j] = 0;
                if(i < j) res[i][j] = 0;
                if (i == j) res[i][j] = 1;
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j<= score; j++) {
               res[i][j] = 2 * res[i-1][j] + res[i-1][j-1];
            }
        }

       return res[n][score];
    }
    private static int test(int left, int right) {
        if (left == right) return left % 2 == 0 ? left : -left;
        int index = left % 2 == 0 ? -(right - left + 1) / 2 : (right - left + 1) / 2;
        if ((right - left + 1) % 2 == 0) {
            return index;
        }else {
            return right % 2 == 0 ? right + index : -right + index;
        }
    }
}
