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
 * BM8 链表中倒数最后k个结点
 * 
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode slow = pHead;
        ListNode fast = pHead;

        int ii = 0;
        for (; (ii < k) & (fast != null); ii++) {
            fast = fast.next;
        }

        if (ii != k) {
            return null;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}