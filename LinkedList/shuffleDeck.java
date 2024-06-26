class Solution {
    public static Node reverselist(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public static Node shuffleDeck(Node node) {
        Node slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node node1 = node;
        Node node2 = slow.next;
        slow.next = null;
        node2 = reverselist(node2);
        node = new Node(0);
        Node curr = node;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        node = node.next;
        return node;
    }
}

// https://course.acciojob.com/idle?question=0d4632ba-59a1-4644-bd9f-8ff8f9e086dc