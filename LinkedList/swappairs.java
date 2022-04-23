class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = head;

        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;
            ListNode b = prev.next.next;

            prev.next = b;
            a.next = b.next;
            b.next = a;

            prev = a;
        }

        return dummy.next;
    }
}

// https://leetcode.com/problems/swap-nodes-in-pairs/