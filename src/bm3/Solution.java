import java.util.*;

class ListNode {
    int val;
    ListNode next = null;
}

public class Solution {
    /**
     * 
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建伪头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, next, end;

        while (pre != null & pre.next != null) {
            /* 检测下一组是否需要翻转 */
            end = pre.next;
            int jj = 0;
            for (; (jj < k - 1) & (end.next != null); jj++) {
                end = end.next;
            }
            if (jj != k - 1) {
                break;
            }

            /* 翻转下一组 */
            head = pre.next;
            next = head.next;
            for (int ii = 0; (ii < k - 1) & (next != null); ii++) {
                // 将head的后一个节点在链表中移出
                next = head.next;
                head.next = next.next;
                // 将next节点加入链表, 位置在pre节点后
                next.next = pre.next;
                pre.next = next;
                int a = 1;
                // head节点后移了一个位置
            }

            /* 开始新的一组 */
            pre = head;
        }
        return dummy.next;
    }
}