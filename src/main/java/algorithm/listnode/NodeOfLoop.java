package algorithm.listnode;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:53 2019-03-29
 * @ Description：链表有环的问题
 * @ Modified By：
 * @Version: $
 */
public class NodeOfLoop {

    /**
     * 判断链表是否有环
     * 使用快慢指针，慢指针每次向前一步，快指针每次两步
     * @param head
     * @return
     */
    public boolean isLoop(ListNode head){
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }


    /**
     * 获取链表环上的入口节点
     * 因此我们就可以分别用一个指针（ptr1, prt2），
     * 同时从head与slow和fast的相遇点出发，每一次操作走一步，直到ptr1 == ptr2，此时的位置也就是入口点！
     * @param head
     * @return
     */
    public ListNode getLoopNode(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null ) return null;//说明没有环
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 获取环的长度
     * 从相遇点开始
     * slow和fast继续按照原来的方式向前走
     * slow = slow -> next; fast = fast -> next -> next；
     * 直到二者再次项目，此时经过的步数就是环上节点的个数 。
     * @param head
     * @return
     */
    public int getLoopLength(ListNode head) {
        ListNode fast = head,slow = head;
        boolean isFirst = false;//是否第一次相遇
        int result = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (isFirst) result++;
            if (fast == slow && !isFirst) {
                isFirst = true;
            }else if (fast == slow && isFirst) return result;
        }
        return 0;
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

    /**
     * 寻找环上一节点最远的节点
     * @param target
     * @return
     */
    public ListNode getFarestNode(ListNode target) {
        ListNode fast = target.next.next;
        ListNode slow = target.next;
        while (fast == target || fast.next == target) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 两个无环链表是否相交
     * @param listA
     * @param listB
     * @return
     */
    public ListNode getTwoListPoint(ListNode listA,ListNode listB) {
        // 1 listA 首尾相接，作为一个环
        ListNode nodeA = listA;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
        }
        nodeA.next = listA;
        // 2 以listB作为首节点，以单链表的形式处理
        return getLoopNode(listB);
    }
}
