import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * BM9 删除链表的倒数第n个节点
 */
public class Solution {
    /**
     * 
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head;
        for (int ii = 0; ii < n; ii++) {
            if (fast == null) {
                return dummy.next;
            }

            fast = fast.next;
        }

        while (fast != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = slow.next;

        return dummy.next;
    }
}