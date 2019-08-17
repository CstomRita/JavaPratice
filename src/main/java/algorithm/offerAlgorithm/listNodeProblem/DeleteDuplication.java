package algorithm.offerAlgorithm.listNodeProblem;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 15:43 2019-03-29
 * @ Description：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @ Modified By：
 * @Version: $
 */
public class DeleteDuplication {

    /**
     * 两次遍历，第一次用Hash记录不重复的元素
     * 第二次再遍历一遍把不重复元素的指针修改
     * 这种方式是有BUG的，在查找重复元素的过程中不能对重复元素remove
     * 这样可能造成前面重复remove掉，后面有add进来了
     * @param pHead
     * @return
     */
    public ListNode deleteDuplicationError(ListNode pHead) {
        HashSet<Integer> set = new HashSet<>();
        ListNode node = pHead;
        while (node != null) {
            if (set.contains(node.val)) {
                set.remove(node.val);
            }else {
                set.add(node.val);
            }
            node = node.next;
        }
        System.out.println(set);
        ListNode result = new ListNode(0);
        ListNode nodeNew = result;
        node = pHead;
        while (node != null) {
            if (set.contains(node.val)) {
                nodeNew.next = node;
                nodeNew = nodeNew.next;
            }
            node = node.next;
        }
        return result.next;
    }

    /**
     * 如何查找重复元素
     * 可以使用HashMap这种，记录key 和 一个标志位
     * 如果包含则将标志位标为-1，即便后面再有一样的，造成的是同样的影响
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode node = pHead;
        while (node != null) {
            if (map.containsKey(node.val)) {
                map.put(node.val,-1);
            }else {
                map.put(node.val,1);
            }
            node = node.next;
        }
        ListNode result = new ListNode(0);
        ListNode nodeNew = result;
        node = pHead;
        System.out.println(map);
        while (node != null) {
            if (map.get(node.val) == 1) {
                nodeNew.next = node;
                nodeNew = nodeNew.next;
            }
            node = node.next;
        }
        nodeNew.next = null;
        return result.next;
    }

    /**
     * 优化算法：注意题目中说明了 这是一个排序的链表
     * 排序好的就不需要额外的HashMap作为辅助了
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        return pHead;
    }
    @Test
    public void test() {
        ListNode listNode = new ListNode(new int[]{1,1,2,3,3,4,5,5});
        System.out.println(listNode.toString());
        System.out.println(deleteDuplication1(listNode));
    }
}
