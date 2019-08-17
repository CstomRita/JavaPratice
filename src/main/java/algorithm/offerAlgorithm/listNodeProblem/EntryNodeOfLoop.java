package algorithm.offerAlgorithm.listNodeProblem;

import algorithm.listnode.NodeOfLoop;
import org.junit.Test;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 22:20 2019-03-28
 * @ Description：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 基本算法，也是要记住的
 * @ Modified By：
 * @Version: $
 */
public class EntryNodeOfLoop {

    /**
     * 判断链表是否有环
     * 暴力法，两词循环遍历
     * 首先从头节点开始，依次遍历单链表的每一个节点。每遍历到一个新节点，就从头节点重新遍历新节点之前的所有节点，
     * 用新节点ID和此节点之前所有节点ID依次作比较。如果发现新节点之前的所有节点当中存在相同节点ID，
     * 则说明该节点被遍历过两次，链表有环；
     * 这样时间复杂度O(n^2)
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode node = pHead;
        int step = 0;
        while (node != null) {
            ListNode node1 = pHead;
            int newStep = step;
            while (newStep > 0) {
                if (node1 == node) return node;
                node1 = node1.next;
                newStep--;
            }
            node = node.next;
            step++;
        }
        return null;
    }

    /**
     * 获取有环链表的总长度
     * @param head
     * @return
     */
    public int getListNodeLength(ListNode head) {
        ListNode fast = head, slow = head;
        boolean isFirst = false;
        int loop = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (isFirst) loop++;
            if (fast == slow && !isFirst) {
                isFirst = true;
            }else if (fast == slow && isFirst) break;
        }
        if (fast == null || fast.next == null) {
            int length = 0;
            //说明没有环
            slow = head;
            while (slow != null) {
                length++;
                slow = slow.next;
            }
            return length;
        }
        // 说明有环，已经获取环r，还需要获取到入口点的距离
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // 获取到fast位于入口点的位置
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            loop++;
        }
        return loop;
    }
    @Test
    public void test() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next.next = node;
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = node;
        System.out.println(getListNodeLength(head));
    }
}
