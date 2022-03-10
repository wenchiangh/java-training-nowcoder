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
 * BM14 链表的奇偶重排
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode pOdd = odd;
        ListNode even = new ListNode(-1);
        ListNode pEven = even;

        for (int ii = 1; head != null; ii++) {
            ListNode curr = head;
            head = head.next;

            if (ii % 2 == 1) {
                pOdd.next = curr;
                pOdd = pOdd.next;
                pOdd.next = null;
            } else {
                pEven.next = curr;
                pEven = pEven.next;
                pEven.next = null;
            }
        }

        pOdd.next = even.next;

        return odd.next;
    }
}