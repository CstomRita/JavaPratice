package algorithm.leetcode.listnode;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:17 2018/9/25
 * @ Description：Solution
 * @ Modified By：
 * @Version: $
 */
public class Solution {

    /**
     * leetcode 第19题
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        if (length == n) { //去掉head
            head = head.next;
            return head;
        }
        node = head;
        for (int j = length - n; j >= 1; j--) {
            if (j == 1) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }

    /***
     * leetcode 第25题
     */
    private ListNode node1;

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        int length = getLength(head,k);
        if(length < k) return head;
        ListNode start = this.node1;
        ListNode node = head;
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        while(node != null) {
            node2 = node1;
            node3 = node2.next;
            swap(node,node2);
            if(getLength(node3,k) < k) {
                node.next = node3;
                break;
            }else {
                node.next = node1;
            }
            node = node3;
        }
        return start;
    }

    private void swap(ListNode node, ListNode node2) {
        System.out.println(node2.val);
        System.out.println(node.val);
        ListNode nodeA = node;
        ListNode nodeB = node.next;
        ListNode nodeC = nodeB.next;
        while(true) {
            nodeB.next = nodeA;
            if(nodeB == node2) {
                System.out.println("break");
                break;
            }
            nodeA = nodeB;
            nodeB = nodeC;
            nodeC = nodeB.next;
        }
        System.out.println(node2.val);
        System.out.println(node.val);
    }

    private int getLength(ListNode node, int k) {
        int length = 0;
        node1 = node;
        while(node1 != null) {
            length++;
            if(length == k) break;
            node1 = node1.next;
        }
        return length;
    }
}
