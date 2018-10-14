package Algorithm.LeetCode;

import java.util.*;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午2:54 2018/9/11
 * @ Description：debug  for leetcode
 * @ Modified By：
 * @Version: $
 */
public class TestDebug {
    public static String convert(String s, int numRows) {
        if (s.length() <= numRows) return s;
        if (numRows == 1) return s;
        int length1 = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            int index = 0;
            while (j < s.length()) {
                System.out.println(j);
                result.append(s.charAt(j));
                if (i == 0 || i == numRows - 1) {
                    j += length1;
                    continue;
                }
                if (index++ % 2 == 0) {
                    j += length1 - 2 * i;
                } else {
                    j += 2 * i;
                }
            }
        }
        return result.toString();
    }


    public static int myAtoi(String str) {
        String str1 = str.trim();
        if (str1.length() == 0) return 0;
        char c = str1.charAt(0);
        System.out.println(c);
        int index = 0;
        if (c >= 48 && c <= 57) {
            index = 3;
        }
        if (c == '-') {
            index = 1;
        }
        if (c == '+') {
            index = 2;
        }
        System.out.println(index);
        if (index == 0) return 0;
        int result = 0;
        int i = index == 3 ? 0 : 1;
        for (; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            if (c1 > 47 && c1 < 58) {
                int num = c1 - 48;
                if (index != 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num >= 7)))
                    return Integer.MAX_VALUE;
                if (index == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num >= 8)))
                    return Integer.MIN_VALUE;
                result = result * 10 + num;
            } else {
                break;
            }
        }
        return index == 1 ? -result : result;
    }

    public boolean isMatch(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();
        int i = length1 - 1;
        int j = length2 - 1;
        int index = 0;
        for (; i >= 0 && j >= 0; ) {
            char c_s = s.charAt(i);
            char c_p = p.charAt(j);
            if (c_s == c_p || c_s == '.' || index == 1) {
                if (index == 1 && c_s != c_p && c_s != '.' || index == 0) {
                    if (index == 1) index = 0;
                    j--;
                } else {
                    i--;
                }

            } else {
                return false;
            }
            if (c_s == '*') {
                index = 1;
                j--;
            }
        }
        if (i > 0) return false;
        while (j >= 0) {
            if (p.charAt(j) != '.' && p.charAt(j) != '*') return false;
            j--;
        }
        return true;
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if(digits.length() == 0) return result;
        String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (char c : digits.toCharArray()) {
            String getMap = map[c-48-2];
            System.out.println(result);
            int length = result.size();
            for (int i = 0; i < length ; i++) {
                String oldResult = result.removeFirst();
                System.out.println(oldResult);
                for (char newAdd : getMap.toCharArray()) {
                    result.add(oldResult + newAdd);
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {

        }

}