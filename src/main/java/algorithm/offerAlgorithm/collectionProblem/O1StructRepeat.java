package algorithm.offerAlgorithm.collectionProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:15 2019-03-18
 * @ Description：设计一个支持在时间复杂度O(1)下执行插入、删除、随机获取的数据结构 支持重复元素
 * insert(val)：向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。\
 * @ Modified By：
 * @Version: $
 */
public class O1StructRepeat {

    class Pair{
        Integer value;//存储的数据
        Integer index;//在下标集合中的下标

        Pair(Integer value,Integer index) {
            this.value = value;
            this.index = index;
        }

    }
    private HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
    private ArrayList<Pair> list = new ArrayList<>();
    private int size = 0;
    private Random random = new Random();

    public int getRandom() {
        return list.get(random.nextInt(size)).value;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) return false;
        ArrayList<Integer> indexs = hashMap.get(val);
        // 1 val更新哈希表
        System.out.println(indexs);
        int index = indexs.remove(indexs.size() - 1);
        if (indexs.size() == 0) hashMap.remove(val);
        // 如果正好是最后一个元素，不必走下面的步骤
        if (index == size - 1) {
            list.remove(size - 1);
            size--;
            return true;
        }
        // 2 交换并删除最后一个元素
        Pair lastObject = list.get(size - 1);
        list.set(index,lastObject);
        list.remove(size - 1);
        // 3 维护哈希表，将lastObject.value设置为index
        indexs = hashMap.get(lastObject.value);
        indexs.set(lastObject.index,index);
        // 4 size--
        size--;
        return true;
    }

    public boolean insert(int val) {
        // 1 哈希表维护
        if (hashMap.containsKey(val)) {
            hashMap.get(val).add(size);
        }else {
            hashMap.put(val,new ArrayList<Integer>(){{add(size);}});
        }
        // 2 添加元素
        list.add(new Pair(val,hashMap.get(val).size()-1));
        // 3 size++
        size++;
        return true;
    }

    @Test
    public void test() {
        O1Struct struct = new O1Struct();
        struct.insert(1);
        struct.remove(2);
        struct.insert(1);
        struct.getRandom();
        struct.remove(1);
        struct.insert(2);
    }
}
