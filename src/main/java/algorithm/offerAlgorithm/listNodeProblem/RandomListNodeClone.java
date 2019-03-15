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
     * 实现深拷贝
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
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

