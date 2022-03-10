import java.util.*;

/**
 * BM5 合并k个已排序的链表
 * 
 * 描述
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 * 数据范围：节点总数 0≤n≤5000，每个节点的val满足∣val∣<=1000
 * 要求：时间复杂度O(nlogn)
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // a dummy head node of new list
        ListNode dummy = new ListNode(-1);
        // add every elemnt in each list to new list
        for (ListNode list : lists) {
            // current node of current list
            ListNode head = list;
            // process every node in current node
            while(head != null){
                // find insert position in new list where value of next node is less than current node
                // or next position is null
                ListNode pre = dummy;
                while(pre.next != null && pre.next.val < head.val){
                    pre = pre.next;
                }
                // insert current node to the position of new list,
                ListNode next = head.next;
                head.next = pre.next;
                pre.next = head;
                
                // current node move to next node
                head = next;
            }
        }

        // return new list
        return dummy.next;
    }
}