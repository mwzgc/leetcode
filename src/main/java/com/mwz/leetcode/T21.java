package com.mwz.leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class T21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int v1 = getFirst(l1);
            int v2 = getFirst(l2);

            ListNode chooseNode = v1 <= v2 ? l1 : l2;
            cur.next = chooseNode;
            chooseNode = chooseNode.next;

            if (v1 <= v2) {
                l1 = chooseNode;
            } else {
                l2 = chooseNode;
            }
        }
        return head.next;
    }

    private int getFirst(ListNode l) {
        if (l == null) return Integer.MAX_VALUE;
        return l.val;
    }
}
