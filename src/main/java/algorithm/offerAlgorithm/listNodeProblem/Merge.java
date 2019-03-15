package algorithm.offerAlgorithm.listNodeProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 16:20 2019-03-11
 * @ Description：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @ Modified By：
 * @Version: $
 */
public class Merge {

    /**
     * 思路一创建一个单独的多个listnode在遍历两者时next较大者，不改变原有listnode，增加list1 + list2的空间复杂度
     * 思路二在原来listnode的基础上改next指针，仅仅创建一个listnode，作为头结点便于返回
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode node = new ListNode(0);
        ListNode result = node;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node = node.next;
                node1 = node1.next;
            }else {
                node.next = node2;
                node = node.next;
                node2 = node2.next;
            }
        }
        //考虑一下其中没有遍历完的情况
        if (node1 != null) node.next = node1;
        if (node2 != null) node.next = node2;
        return result.next;
     }

     @Test
     public void test() {
        ListNode listNode1 = ListNode.init();
         System.out.println(listNode1);
         ListNode listNode2 = new ListNode(2);
         listNode2.next = new ListNode(3);
         listNode2.next.next = new ListNode(3);
         listNode2.next.next.next = new ListNode(4);
         System.out.println(listNode2);
         System.out.println(Merge(listNode1,listNode2));

     }
}
