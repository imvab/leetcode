class Solution {
    public ListNode sortList(ListNode head) {
        head = mergeSort(head);
        return head;
    }

    public ListNode mergeSort(ListNode head) {
        // If list is empty or list has only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Get The middle of the list
        ListNode mid = getMid(head);
        ListNode first = head;
        ListNode second = mid.next;
        mid.next = null;

        // Apply MergeSort in the left sub-list
        ListNode left = mergeSort(head);

        // Apply MergeSort in the right sub-list
        ListNode right = mergeSort(second);

        // Merge both left and right sub-list
        ListNode sortedList = merge(left, right);
        return sortedList;
    }

    // Return The Middle Element. If there are two middle element, return the first
    // middle element
    public ListNode getMid(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }

    // Merge Two Sub-List
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode ans = new ListNode();
        ListNode head = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ans.next = list1;
                list1 = list1.next;
            } else {
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }

        if (list1 != null) {
            ans.next = list1;
        }

        if (list2 != null) {
            ans.next = list2;
        }
        return head.next;
    }
}

// https://leetcode.com/problems/sort-list/