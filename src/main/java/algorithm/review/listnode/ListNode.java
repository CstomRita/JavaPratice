package algorithm.review.listnode;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:16 2018/9/25
 * @ Description：链表
 * @ Modified By：
 * @Version: $
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int[] val) {
        this.val = val[0];
        ListNode node = this;
        for (int i = 1; i < val.length; i++) {
            node.next = new ListNode(val[i]);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        ListNode node = this;
        while (node != null) {
            stringBuilder.append(node.val + " ");
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
