package algorithm.offerAlgorithm.listNodeProblem;

import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 17:48 2019-03-19
 * @ Description：输入两个链表，找出它们的第一个公共结点。
 * @ Modified By：
 * @Version: $
 */
public class FindFirstCommonNode {


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        ListNode result = null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (node1 != null) {
            stack1.push(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2);
            node2 = node2.next;
        }
        while (!stack1.empty() && !stack2.empty() && stack1.peek().equals(stack2.peek())) {
            stack1.pop();
            result = stack2.pop();
        }
        return result;
    }
}
