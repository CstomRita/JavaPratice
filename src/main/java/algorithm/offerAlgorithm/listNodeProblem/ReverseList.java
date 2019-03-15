package algorithm.offerAlgorithm.listNodeProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:46 2019-03-11
 * @ Description：输入一个链表，反转链表后，输出新链表的表头。
 * @ Modified By：
 * @Version: $
 */
public class ReverseList {

    /**
     * 两个两个解决
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            ListNode index = right.next;
            right.next = left;
            left = right;
            right = index;
        }
        head.next = null;
        return left;
    }

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        System.out.println(root);
        System.out.println(ReverseList(root));
    }
}
