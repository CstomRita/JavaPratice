package algorithm.offerAlgorithm.listNodeProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:31 2019-03-15
 * @ Description：输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 * @ Modified By：
 * @Version: $
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

}
public class RandomListNodeClone{
    /**
     * 实现深拷贝的复制一个链表
     * @param pHead
     * @return
     */
    public RandomListNode oldClone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode node = new RandomListNode(0);
        RandomListNode nodeA = node;
        RandomListNode nodeB = pHead;
        while (nodeB != null) {
            nodeA.next = new RandomListNode(nodeB.label);
            nodeB = nodeB.next;
            nodeA = nodeA.next;
        }
        nodeB = pHead;
        nodeA = node.next;
        RandomListNode randomListNodeB = pHead;
        RandomListNode randomListNodeA = node.next;
        while (nodeB != null) {
            if (nodeB.random != null) {
                randomListNodeB = pHead;
                randomListNodeA = node.next;
                while (randomListNodeB != nodeB.random) { //是否一个节点，是否指向一个地址空间
                    randomListNodeB = randomListNodeB.next;
                    randomListNodeA = randomListNodeA.next;
                }
                nodeA.random = randomListNodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return node.next;
    }

    /**
     *
     【链表复制思路】
     1. 遍历一次链表，创建出所有的节点，但是区别在于创建的新节点位于旧节点之后，作为旧节点的Next，在旧链表的后面创建新的链表节点,新节点的 = 旧节点.next
     2. 再遍历一次链表，寻找random节点，但是由于新旧节点在一个链表中，有新节点.random = 旧节点.random.next的关系，这样可以利用节点不需要再次遍历，时间复杂度O(n)
     3. 把新旧链表从一个链表中拆分出来
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        // 1 在旧节点后面创建原有节点
        RandomListNode node  = pHead;
        while (node != null) {
            RandomListNode next = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = next;
            node = next;
        }

        // 2 再次遍历，新节点.random = 旧节点.random.next
        node = pHead;
        while (node != null) {

            node.next.random = node.random == null ? null : node.random.next; //random可能为空，需要判断
            node = node.next.next;
        }

        // 3 再遍历拆分
        RandomListNode copyHead = pHead.next;
        node = pHead;
        RandomListNode temp;
        while (node != null) {
            temp = node.next;
            node.next = temp == null ? null : temp.next;
            node = temp;
        }
        return copyHead;
    }

    @Test
    public void test() {
        RandomListNode pHead = new RandomListNode(1);
        pHead.next = new RandomListNode(2);
        pHead.next.next = new RandomListNode(3);
        pHead.random = pHead.next.next;
        pHead.next.random = pHead;
        RandomListNode node = Clone(pHead);
        System.out.println(node.label);
        System.out.println(node.random.label);
    }
}

