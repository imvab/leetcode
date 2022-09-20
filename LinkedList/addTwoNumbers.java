class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result; // copy
        
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            result.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            result.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            result = result.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            result.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            result = result.next;
            l2 = l2.next;
        }
        
        if (carry == 1) {
            result.next = new ListNode(carry);
        }
        
        return head.next;
    }
}