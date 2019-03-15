package algorithm.offerAlgorithm.listNodeProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:49 2019-03-08
 * @ Description：从尾到头顺序返回链表的list
 * @ Modified By：
 * @Version: $
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode init() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        return node;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuffer stringBuffer = new StringBuffer();
        while (node != null) {
            stringBuffer.append(node.val+"__");
            node = node.next;
        }
        stringBuffer.append("null");
        return stringBuffer.toString();
    }
}

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> result = new Stack<>();
        while (listNode != null) {
            result.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!result.empty()) {
            arrayList.add(result.pop());
        }
        return arrayList;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(printListFromTailToHead(node));
    }
}
