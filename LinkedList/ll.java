class Solution {
    public static void remove(LinkedList ll, int toRemove) {

        if (ll.head == null)
            return;
        if (toRemove == 0) {
            ll.head = ll.head.next;
            return;
        }
        Node curr = ll.head;
        for (int i = 0; i < toRemove - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }
}

class Solution {
    static Node insert(Node head, int n, int pos, int val) { // Write your code here.
        Node newNode = new Node(val);

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (pos == n) {
            temp.next = newNode;
            return head;
        }
        temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
}

class Solution {
    static Node midpointOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}

class Solution {
    void deleteNode(Node node) {
        // Your code here
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}