class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        fast = head
        slow = head
        
        while (fast and fast.next):
            fast = fast.next.next
            slow = slow.next
        
        prev = None
        while (slow):
            next = slow.next
            slow.next = prev
            prev = slow
            slow = next
            
        while (prev):
            if (prev.val != head.val):
                return False
            prev = prev.next
            head = head.next
        return True