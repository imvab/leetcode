class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode head = merged;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                merged.next = new ListNode(list1.val);
                merged = merged.next;
                list1 = list1.next;
            } else {
                merged.next = new ListNode(list2.val);
                merged = merged.next;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            merged.next = new ListNode(list1.val);
            merged = merged.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            merged.next = new ListNode(list2.val);
            merged = merged.next;
            list2 = list2.next;
        }

        return head.next;
    }
}

// https://leetcode.com/problems/merge-two-sorted-lists/