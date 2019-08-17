package algorithm.offerAlgorithm.collectionProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 22:00 2019-03-17
 * @ Description：
 * 设计一个支持在时间复杂度O(1)下执行插入、删除、随机获取的数据结构
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * @ Modified By：
 * @Version: $
 */
public class O1Struct {
    private HashMap<Integer,Integer> hashMap = new HashMap<>();
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int size = 0;
    private Random random = new Random();


    public boolean  insert(int val) {
        if (hashMap.containsKey(val)) return false;
        hashMap.put(val,size++);
        arrayList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) return false;
        // 1 获取目标下标
        int index = hashMap.remove(val);
        // 如果正好是最后一个元素，不必走下面的步骤
        if (index == size - 1) {
            arrayList.remove(size - 1);
            size--;
            return true;
        }
        // 2 和最后一个元素交换后删除最后一个元素
        int lastObject = arrayList.get(size-1);
        arrayList.set(index,lastObject);
        arrayList.remove(size - 1);
        // 3 更新哈希值
        hashMap.put(lastObject,index);
        size--;
        return true;
    }

    public int getRandom() {
        //获取的是[0,size)之间的🌲，要求size>0，因此需要考虑size==0时的情况
        return arrayList.get(random.nextInt(size)); //生成0-n的随机数
    }

    @Test
    public void test() {
        O1StructRepeat o1StructRepeat = new O1StructRepeat();
        o1StructRepeat.insert(1);
        o1StructRepeat.insert(1);
        o1StructRepeat.insert(2);
        o1StructRepeat.insert(2);
        o1StructRepeat.insert(3);
        o1StructRepeat.insert(3);
        o1StructRepeat.remove(1);
        o1StructRepeat.remove(1);
        o1StructRepeat.remove(3);
        o1StructRepeat.remove(3);
        o1StructRepeat.insert(1);
    }

}
