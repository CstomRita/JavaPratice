package algorithm.examination.niuke;

import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:16 2019-08-31
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Main8 {

    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int maxPointNum = scanner.nextInt(); //设置节点 0-pointNum-1
            int lineNum = scanner.nextInt();
            int[] lines = new int[lineNum];
            for (int i = 0; i < lineNum;i++) {
                lines[i] = scanner.nextInt();
            }
            getLine(lines,0,0,0,maxPointNum-1);
            System.out.println(2*count);
        }
    }

    private static void getLine(int[] lines,int start,int maxEnd,int lineNumber,int maxPointNum) {
        if (start > maxPointNum || start < 0) {
            //此路不通
            return;
        }
        if (lineNumber >= lines.length) {
            //路走完了
            count += maxPointNum - maxEnd + 1;
            return;
        }
            getLine(lines,start+lines[lineNumber],Math.max(maxEnd,start+lines[lineNumber]),lineNumber+1,maxPointNum);
            getLine(lines,start-lines[lineNumber],Math.max(maxEnd,start-lines[lineNumber]),lineNumber+1,maxPointNum);
    }
}
