package bm1;

/**
 * 描述
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * <p>
 * 数据范围： 0≤n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 * <p>
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 *
 * 测试结果
 * 运行时间：90ms
 * 超过5.19% 用Java提交的代码
 * 占用内存：13212KB
 * 超过44.30%用Java提交的代码
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode previous = null, current = head, next;
        while (current != null) {
            next = current.next;
            if (previous == null) {
                previous = current;
                current = next;
                previous.next = null;
            } else {
                current.next = previous;
                previous = current;
                current = next;
            }
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = null, next = null;
        for (int ii = 0; ii < 1; ii++) {
            if (head == null) {
                head = next = new ListNode(ii);
                head.next = null;
            } else {
                next.next = new ListNode(ii);
                next.next.next = null;
                next = next.next;
            }
        }

        PrintList(head);
        Solution solution = new Solution();
        ListNode reversedHead = solution.ReverseList(head);
        PrintList(reversedHead);
    }

    public static void PrintList(ListNode head) {
        ListNode next = head;
        while (next != null) {
            System.out.print(next.val);
            if (next.next != null) {
                System.out.print(" -> ");
            }
            next = next.next;
        }
    }
}
