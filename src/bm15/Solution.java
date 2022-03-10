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
 * BM15 删除有序链表中重复的元素-I
 */
public class Solution {
    /**
     * 
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode curr = head;
            head = head.next;

            ListNode pre = dummy;
            while (pre.next != null && pre.next.val != curr.val) {
                pre = pre.next;

            }

            if (pre.next == null) {
                pre.next = curr;
                pre = pre.next;
                pre.next = null;
            }

        }

        return dummy.next;

    }
}