package algorithm.codinginterviewguide.stringproblem;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:52 2019-09-02
 * @ Description：数字的中英文表达
 * @ Modified By：
 * @Version: $
 */
public class ChinEnglishForNum {

    static HashMap<Integer,String> chinese = new HashMap<>();
    static HashMap<Integer,String> english = new HashMap<>();

    private static void init() {
        chinese.put(0,"零");
        chinese.put(1,"一");
        chinese.put(2,"二");
        chinese.put(3,"三");
        chinese.put(4,"四");
        chinese.put(5,"五");
        chinese.put(6,"六");
        chinese.put(7,"七");
        chinese.put(8,"八");
        chinese.put(9,"九");

        english.put(0,"零");
        english.put(1,"一");
        english.put(2,"二");
        english.put(3,"三");
        english.put(4,"四");
        english.put(5,"五");
        english.put(6,"六");
        english.put(7,"七");
        english.put(8,"八");
        english.put(9,"九");

    }

    //输出两行，第一行为数字的英文表达，第二行为数字的中文表达
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init();
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            String[] out = chineseEnglishExpression(number);
            System.out.println(out[0]);
            System.out.println(out[1]);
        }
    }

    private static String[] chineseEnglishExpression(int number) {
        Stack chineseStack = new Stack();
        Stack englishStack = new Stack();
        int index = number;
        if (index < 0) {
            chineseStack.push("负");
            englishStack.push("Negative");
        }
        while (index != 0) {
            int remainder = index % 10;
            chineseStack.push(chinese.get(remainder));
            englishStack.push(english.get(remainder));
            index = index / 10;
        }
        String[] out = new String[2];
        out[0] = chineseStack.toString();
        out[1] = englishStack.toString();
        return out;
    }
}
