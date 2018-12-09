package algorithm.leetcode.listnode;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:16 2018/9/25
 * @ Description：listnode
 * @ Modified By：
 * @Version: $
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
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
