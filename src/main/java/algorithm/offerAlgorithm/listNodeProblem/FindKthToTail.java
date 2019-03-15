package algorithm.offerAlgorithm.listNodeProblem;

import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:32 2019-03-11
 * @ Description：输入一个链表，输出该链表中倒数第k个结点。
 * @ Modified By：
 * @Version: $
 */
public class FindKthToTail {

    /**
     * 给定一个长度k的，想到双指针维护一个窗口
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if( k <= 0) return null;
        ListNode begin = head;
        ListNode end = head;
        while (end != null) {
            if(k != 0) {
                end = end.next;
                k--;
            }else {
                begin = begin.next;
                end = end.next;
            }
        }
        //如果这个链表长度小于k，倒数第K个返回null
        return k == 0 ? begin : null;
    }

    @Test
    public void test() {
        ListNode head = ListNode.init();
        System.out.println(FindKthToTail(head,4).val);

    }
}
