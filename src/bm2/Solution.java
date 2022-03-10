import java.util.*;

// 描述
// 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
// 例如：
// 给出的链表为 1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
// 返回 1→4→3→2→5→NULL.

// 数据范围： 链表长度 0<m≤n≤size，链表中每个节点的值满足 ∣val∣≤1000
// 要求：时间复杂度O(n) ，空间复杂度O(n)

class ListNode {
 int val;
 ListNode next = null;
}

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 创建一个新的节点，指向头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 创建翻转部分节点的前置指针, 初始状态指向dummy, head的前一个节点
        ListNode pre = dummy;

        // pre后移到指定的第m个节点前, 也就是m-1个节点, pre不动
        for(int ii = 0; ii < m-1; ii++){
            pre = pre.next;
        }

        // 将head指向第m个节点, 也就是pre的后一个节点, head不动
        head = pre.next;
        // 执行m-n-1次交换, 将head的后一个节点交换到pre的后一个节点
        ListNode next;
        for(int ii = m; ii < n; ii++){
            // 每次循环head的后一个节点交换到pre的后一个节点
            // next指向head的后一个节点
            next = head.next;
            // 将next与链表断开, head与next的后一个节点链接
            head.next = next.next;
            // next节点与pre的后一个节点链接
            next.next = pre.next;
            // next节点加入链表, 链接到pre后面
            pre.next = next;
        }

        // 返回头节点
        // 注意的是m=0的情况, dummy和pre都指向空头节点,
        // dummy还是会指向翻转后的头节点, 因此也是dummy.next是头节点
        return dummy.next;
    }
}