package LeetCode.ListNode;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:17 2018/9/25
 * @ Description：Solution
 * @ Modified By：
 * @Version: $
 */
public class Solution {

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
}
