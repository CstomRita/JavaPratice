package algorithm.examination.niuke;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:51 2019-03-14
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Main1 {

    private static ArrayList<Integer> result = new ArrayList<>();
    private static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, k = 0 ;
        while (in.hasNextInt()) {
             n = in.nextInt();
             k = in.nextInt();
             getminPath(n,k,1,new ArrayList<>(),0);
            for(int i : result) {
                if (i < 0) {
                    System.out.println(-i + " -");
                }else {
                    System.out.println(i + " +");
                }
            }
            }
        }

    /**
     * k个节点相加或相减正好等于n
     * 优先找左子树，找到就跳出
     * @param target
     * @param k
     */
    private static void getminPath(int target, int k, int value, ArrayList<Integer> list, int sum){
        if (k == 0 && target == 0) {
            if (sum < minSum) {
                result = new ArrayList<>(list);
            }
        }
        if (k == 0 && target != 0) return;
        sum += value;
        list.add(value);
        getminPath(target-value,k-1,2*value,list,sum);
        getminPath(target-value,k-1,value*2+1,list,sum);
        list.remove(list.size()-1);

        list.add(-value);
        getminPath(target+value,k-1,2*value,list,sum);
        getminPath(target+value,k-1,value*2+1,list,sum);
        list.remove(list.size()-1);
    }
}