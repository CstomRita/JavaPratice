package algorithm.examination.niuke;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:18 2019-04-08
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            double j = scanner.nextDouble();
            scanner.nextLine();
            String s1 = scanner.nextLine();
            System.out.println("putput:int"+i+"string:"+s1 + j);

    }

    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
    }
}
