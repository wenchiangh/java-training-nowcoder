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
 * BM11 链表相加(二)
 */
public class Solution {
    /**
     * 
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        head1 = ReverseList(head1);
        head2 = ReverseList(head2);

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (head1 != null || head2 != null) {
            pre.next = new ListNode(-1);
            pre = pre.next;

            if (head1 != null && head2 != null) {
                pre.val = head1.val + head2.val;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1 != null) {
                pre.val = head1.val;
                head1 = head1.next;
            } else {
                pre.val = head2.val;
                head2 = head2.next;
            }
        }

        pre = dummy.next;
        while (pre != null) {
            if (pre.val > 9) {
                if (pre.next == null) {
                    pre.next = new ListNode(0);
                }
                pre.val = pre.val - 10;
                pre.next.val = pre.next.val + 1;
            }

            pre = pre.next;
        }

        dummy.next = ReverseList(dummy.next);

        return dummy.next;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;
        ListNode next;

        while (curr != null && curr.next != null) {
            next = curr.next;

            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}