package algorithm.examination.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 19:31 2019-08-04
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int pointNum = in.nextInt();
            int lineNum = in.nextInt();
            int testNum = in.nextInt();
            int[][] lines = new int[pointNum][pointNum];
            int[] times = new int[pointNum];
            for (int i = 0; i < lineNum; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                lines[start][end] = in.nextInt(); //从i到j的时间花费
            }
            int result = 0;
//            getResult(lines,times,pointNum);
            dijkstra(lines,times);
            System.out.println(Arrays.toString(times));
            for (int j = 0; j < testNum;j++) {
                result += times[in.nextInt()];
            }
            System.out.println(result);
        }
    }

    private static void getResult(int[][] lines, int[] times,int pointNum) {
        for (int i = 0; i < pointNum; i++) {
            for (int j = 0; j < pointNum; j++) {
                if (times[i] <= 0) {
                    times[i] = (times[j] + lines[j][i]);
                }else {
                    times[i] = Math.min(times[i],(times[j] + lines[j][i]));
                }
            }
        }
    }

    private static void dijkstra(int[][] lines,int[] points) {
        // 1 初始化points
        for(int i = 1; i < points.length; i++) {
            points[i] = Integer.MAX_VALUE;
        }

        // 2 算法流程
        int start = 0; //从起点0开始
        int end = 0;
        for (int j = 0; j < points.length - 1; j++) {
            int min = Integer.MAX_VALUE;

            // 2.1 for循环寻找从start开始最近的点 end（确定顶点），当然这个顶点是未在集合中的
            for (int k = 0; k < points.length; k++) {
                if (points[k] == Integer.MAX_VALUE && lines[start][k] != 0 && lines[start][k] < min) {
                    min = lines[start][k];
                    end = k;
                }
            }
            points[end] = points[start] + min;

            // 2.2更新points数组中其他点到end的值（确定值）
            for (int k = 0; k < points.length; k++) {
                points[end] = lines[k][end] != 0 ? Math.min(points[end],(points[k] + lines[k][end])) : points[end];
            }

            // 2.3end作为新的源点
            start = end;
        }

    }
}
