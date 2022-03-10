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
 * BM16 删除有序链表中重复的元素-II
 */
public class Solution {
    /**
     * 
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = pre.next;

        while (curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                pre = curr;
                curr = curr.next;
            } else {
                ListNode t = pre.next;
                while (t != null && t.val == curr.val) {
                    t = t.next;
                }
                pre.next = t;
                curr = pre.next;
            }
        }

        return dummy.next;
    }
}