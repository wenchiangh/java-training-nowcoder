import java.util.*;

/**
 * BM6 判断链表中是否有环
 * 
 * 描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 数据范围：链表长度0≤n≤10000，链表中任意节点的值满足∣val∣<=100000
 * 要求：空间复杂度O(1)，时间复杂度O(n)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // if a cycle in the list,
        // slow always meet fast
        while (fast != null && fast.next != null) {
            // one step for slow
            slow = slow.next;
            // two step for fast
            fast = fast.next.next;

            // slow meet fast, a cycle
            if (slow == fast) {
                return true;
            }
        }

        // none cycle
        return false;
    }
}