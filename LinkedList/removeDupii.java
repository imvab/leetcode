class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
       
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
 
        ListNode copy = dummy;
 
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                dummy.next = head.next;
                head = head.next;
            } else {
                dummy = head;
                head = head.next;
            }
        }
 
        return copy.next;
    }
}

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/