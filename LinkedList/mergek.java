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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }

        while (lists.length > 1) {
            ArrayList<ListNode> merged = new ArrayList<ListNode>();
            for (int i = 0; i < lists.length; i = i + 2) {
                ListNode l1 = lists[i];
                ListNode l2;

                if (i + 1 < lists.length) {
                    l2 = lists[i + 1];
                } else {
                    l2 = null;
                }

                merged.add(mergeTwoLists(l1, l2));
            }
            lists = merged.toArray(new ListNode[0]);
        }

        return lists[0];
    }
}
