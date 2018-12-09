package noramlpratice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:07 2018/11/21
 * @ Description：集合的Test
 * @ Modified By：
 * @Version: $
 */
public class CollectionTest {

    private List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,7}));

    /**
     * 集合迭代过程中remove异常
     */
    @Test
    public  void remove() {
        // 1 使用Iterator提供的remove方法，用于删除当前元素
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//           Integer value = iterator.next();
//           if (value == 3) iterator.remove();
//        }
        System.out.println(list);
        // 2 不使用Iterator，使用索引遍历
        int length = list.size();
        //这么写的话length就是固定的，如果list.size()写在for循环里那么每次都会重新计算一下size的length
        //这里是控制是否溢出的地方
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i);
            Integer value = list.get(i);
            if(value == 3) {
                list.remove(value);
                i--;//i--的作用是删除这个元素之后，下一个元素就会占据这一个下标，目的是为了不忽略元素，和溢出没有关系
            }
        }
        System.out.println(list);
    }
}
