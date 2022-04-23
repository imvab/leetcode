class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode nth = head;

        for (int i = 0; i < n; i++)
            head = head.next;

        ListNode prev = dummy;

        while (head != null) {
            prev = nth;
            nth = nth.next;
            head = head.next;
        }
        prev.next = nth.next;
        return dummy.next;
    }
}

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/