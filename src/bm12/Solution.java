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
 * BM12 单链表的排序
 */
public class Solution {
    /**
     * 
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = null;

        while (head != null) {
            ListNode sort = head;
            head = head.next;

            sort.next = null;

            ListNode ins = dummy;
            while (ins != null && ins.next != null && ins.next.val > sort.val) {
                ins = ins.next;
            }

            sort.next = ins.next;
            ins.next = sort;

        }

        return dummy.next;
    }
}