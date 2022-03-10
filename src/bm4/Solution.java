/*
* BM4 合并两个排序的链表
*
* 描述
* 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
* 数据范围： 0≤n≤1000,  -1000≤节点值≤1000
* 要求：空间复杂度 O(1)，时间复杂度 O(n)
* 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：
*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        // dummy head
        ListNode dummy = new ListNode(-1);
        ListNode head1 = list1, head2 = list2, head = dummy;

        // end process when two list all end
        while (head1 != null | head2 != null) {
            if (head1 != null && head2 != null) {
                // do something when two list not end
                if (head1.val < head2.val) {
                    // value of head node in list 1 less than list 2
                    // move head node of list 1 to new list
                    head.next = head1;

                    // head of list 1 move next
                    head1 = head1.next;

                    // current head node of new list move to next
                    head = head.next;
                } else {
                    // value of head node in list 2 less than list 1
                    // move head node of list 2 to new list
                    head.next = head2;

                    // head of list 2 move next
                    head2 = head2.next;

                    // current head node of new list move to next
                    head = head.next;
                }
            } else if (head1 != null) {
                // do something when just head 1 not end
                // add first node of list 1 to new list
                head.next = head1;

                // head of list 1 move next
                head1 = head1.next;

                // current head node of new list move to next
                head = head.next;
            } else {
                // do something when just list2 not end
                // add first node of list 2 to new list
                head.next = head2;

                // head of list 2 move next
                head2 = head2.next;

                // current head node of new list move to next
                head = head.next;
            }
        }

        // return new list
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}