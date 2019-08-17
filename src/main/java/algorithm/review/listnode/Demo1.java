package algorithm.review.listnode;

import org.junit.Test;

import java.util.*;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 10:10 2019-05-14
 * @ Description：第一次复习
 * @ Modified By：
 * @Version: $
 */
public class Demo1 {

    /**
     *1. 删除链表中重复的节点
     *     1. 保留链表中重复节点中的一个节点 例如 1-2-2-3-4-5 变成 1-2-3-4-5
     *     2. 所有重复过的节点都不保留 例如 1-2-2-3-4-5 变成 1-3-4-5
     * 2. 反转链表
     * 3. 从尾到头顺序返回链表的list
     * 4. 链表中倒数第k个结点
     * 5. 链表是否有环的问题
     *     1. 链表是否有环
     *     2. 获取链表环的入口节点
     *     3. 获取环的长度
     *     4. 获取有环链表的总长度
     *     5. 寻找离环上一点最远的节点
     *     6. 两个链表是否相交
     * 6. 合并两个链表（输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则）
     */


    /**
     * 保留链表中重复节点中的一个节点 例如 1-2-2-3-4-5 变成 1-2-3-4-5
     * 利用HashSet记录，是否是重复元素
     * 如果元素重复则删除 此元素
     * @param root
     */
    public ListNode deleteReapt(ListNode root) {
        ListNode phead = new ListNode(0);
        phead.next = root;

        ListNode beforeNode = phead;
        ListNode node = root;
        HashSet<Integer> res = new HashSet<>();

        while (node != null) {
            if (res.contains(node.val)) { //重复元素直接删除
                beforeNode.next = node.next;
                node = beforeNode.next;
            }else {
                res.add(node.val);
                beforeNode = beforeNode.next;
                node = beforeNode.next;
            }
        }
        return phead.next;
    }

    /**
     * 1.2 所有重复过的节点都不保留 例如 1-2-2-3-4-5 变成 1-3-4-5
     * 因为一个节点都不会保留 必然要遍历完所有的节点才能知道之前的节点会不会保留
     * 肯定是两次遍历了
     * 利用一个HashMap维护<元素，是否重复>的hashmap
     * 之后再遍历一次
     * @param root
     * @return
     */
    public ListNode deleteDuplication(ListNode root) {
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        ListNode node = root;
        while (node != null) {
            if (hashMap.containsKey(node.val)) {
                hashMap.put(node.val,false);
            }else {
                hashMap.put(node.val,true);
            }
            node = node.next;
        }
        // 第二次遍历，只找不重复元素 true
        node = root;
        ListNode phead = new ListNode(0);
        ListNode head = phead;
        while (node != null) {
            if (hashMap.get(node.val)) {
                phead.next = node;
                phead = phead.next;
            }
            node = node.next;
        }
        phead.next = null;//不要忘记这一行
        return head.next;
    }

    /**
     * 翻转链表
     * 要点：两个为一组 两个为一组的翻转
     * @param root
     * @return
     */
    public ListNode reverseListNode(ListNode root) {
        if (root == null || root.next == null) return root;
        ListNode beforeNode = root;
        ListNode node = root.next;
        ListNode temp;
        while (node != null) {
            temp = node.next;
            node.next = beforeNode;
            beforeNode = node;
            node = temp;
        }
        root.next = null;//最后更新一下首节点的next
        return beforeNode;
    }

    /**
     * 从尾到头顺序返回链表的list
     * 从尾到头部，先遍历的在后面，想到了什么？ 栈
     * 用栈存储就十分简单了
     * 之后再pop出来
     * @param root
     * @return
     */
    public List revserList(ListNode root) {
        Stack<Integer> stack = new Stack<>();
        while (root != null) {
            stack.push(root.val);
            root = root.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 找到尾部倒数第K个元素
     * 这里使用双指针维护一个K长的窗口
     * 一直便利到后指针为null，那个前指针就是倒数第K个元素了
     * @param root
     * @return
     */
    public ListNode findKthFromTail(ListNode root,int k) {
        ListNode start = root;
        ListNode node = root;
        ListNode end;
        while (k > 0 && node!=null) {
            node = node.next;
            k--;
        }
        if (k > 0) return null;//没有K个元素
        end = node;
        while (end != null) {
            end = end.next;
            start = start.next;
        }
        return start;
    }

    /**
     * 判断链表是否有环
     * 快慢指针法，如果相遇了一定是有环
     * @param root
     * @return
     */
    public boolean isLoop(ListNode root) {
        ListNode fast = root;
        ListNode slow = root;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 判断是否有环，并给出入口节点，如果无环则返回null
     * 找到相遇点
     * 之后两个慢指针一个从root开始，一个从相遇点开始，每次都是一步
     * @param root
     * @return
     */
    public ListNode findBeginOfLoop(ListNode root) {
        ListNode fast = root, slow = root;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 有环 相遇
                break;
            }
        }
        fast = root;
        while (fast != null && slow != null) {
            if (fast == slow) return fast;
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }

    /**
     * 获取环的长度
     * 对于环上的一点，一个指针两步 一个指针一步 走的步数就是环的长度
     * @param root
     * @return
     */
    public int getLengthOfLoop(ListNode root) {
        ListNode fast = root, slow = root;
        int step = 0;
        boolean isFirst = true;//是否第一次相遇，为了确定相遇点
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (!isFirst) step++;
            if (fast == slow && isFirst) isFirst = false;
            if (fast == slow && !isFirst) return step;
        }
        return 0;
    }
    @Test
    public void test() {
        ListNode root = new ListNode(new int[]{2,4,5,5});
        System.out.println(root);
        System.out.println(findKthFromTail(root,4));
    }
}
