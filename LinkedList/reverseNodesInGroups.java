class Solution {
    public ListNode reverse(ListNode head, int k, int count) {
        // return head of end part of list where nodes are less than k
        if (count < k) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int c = 0;

        // iterate till k nodes are reversed
        while (c < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }

        // after loop, head will connect to prev pointer returned from recursion call
        if (curr != null) {
            head.next = reverse(curr, k, count - k);
        }
        return prev;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        // count number of nodes
        int count = 0;

        while (curr != null) {
            curr = curr.next;
            ++count;
        }
        return reverse(head, k, count);
    }
}

// https://leetcode.com/problems/reverse-nodes-in-k-group/