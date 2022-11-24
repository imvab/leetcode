class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        dummy = ListNode()
        dummy.next = head
        pre = dummy
        
        for i in range(m - 1):
            pre = pre.next
            
        curr = pre.next
        reverse = None
        
        for i in range(n - m + 1):
            next = curr.next
            curr.next = reverse
            reverse = curr
            curr = next
        pre.next.next = curr
        pre.next = reverse
        return dummy.next

// https://leetcode.com/problems/reverse-linked-list-ii/description/