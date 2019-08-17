package algorithm.offerAlgorithm.stringProblem;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:14 2019-03-19
 * @ Description：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中
 * 找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * @ Modified By：
 * @Version: $
 */
public class FirstNotRepeatingChar {

    /**
     * 第一思路使用hashmap查找对象是否存在，和第一次出现的下标
     * 使用arraylist维护下标，最后remove掉
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar1(String str) {
        if (str == null || str.length() == 0) return -1;
        HashMap<Character,Integer> hashMap = new HashMap();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (hashMap.containsKey(character)) {
                list.add(hashMap.get(character));
            }else {
                hashMap.put(character,i);
            }
        }
        ArrayList<Integer> values = new ArrayList<>(hashMap.values());
        System.out.println(values);
        System.out.println(list);
        values.removeAll(list);
        System.out.println(values);
        Collections.sort(values);
        return values.size() == 0 ? -1 : values.get(0);
    }

    /**
     * 思路二：hashMap维护对象和出现次数 第一次遍历
     * 再遍历一次找到hashmap中出现次数为1 的下标
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        HashMap<Character,Integer> hashMap = new HashMap();
        for (Character c : str.toCharArray()) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c,hashMap.get(c)+1);
            }else {
                hashMap.put(c,1);
            }
        }

        for(int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
    @Test
    public void test() {
        System.out.println(FirstNotRepeatingChar("google"));
    }
}
