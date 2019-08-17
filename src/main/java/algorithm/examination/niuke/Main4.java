package algorithm.examination.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 18:53 2019-04-24
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main4 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int total = Integer.parseInt(br.readLine());
//        int[] prices = parseInts(br.readLine().split(" "));
//        int[] hots = parseInts(br.readLine().split(" "));
        int total = 1000;
        int[] prices = new int[]{200,600,100,180,300,450};
        int[] hots = new int[]{6,10,3,4,5,8};
        solution(total,prices,hots);
    }
    public static void solution(int total,int[] prices,int[] hots) {
        int[][] results = new int[prices.length+1][total+1];
        for (int i = 1; i < prices.length+1; i++) {
            for (int j = 1; j < total+1; j++) {
                if (j < prices[i-1]) {
                    results[i][j] = results[i-1][j];
                }else {
                    results[i][j] = Math.max(results[i-1][j],results[i-1][j-prices[i-1]]+hots[i-1]);
                }
            }
        }
        System.out.println(results[prices.length][total]);
    }
}

