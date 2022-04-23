class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        ListNode temp = l1;
        while (temp != null) {
            s1.push(temp.val);
            temp = temp.next;
        }

        temp = l2;
        while (temp != null) {
            s2.push(temp.val);
            temp = temp.next;
        }

        int carry = 0;
        temp = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry == 1) {
            int sum = carry;

            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();

            ListNode newNode = new ListNode();
            newNode.val = sum % 10;
            newNode.next = temp;
            temp = newNode;
            carry = sum / 10;
        }
        return temp;
    }
}