/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<Node, Node>();

        Node dummy = new Node(0);
        Node copy = dummy;
        Node temp = head;

        // copy val and next to new LL and mapping in hm
        while (temp != null) {
            Node newNode = new Node(temp.val);
            copy.next = newNode;
            copy = copy.next;
            hm.put(temp, copy);
            temp = temp.next;
        }

        // copy the random using the hm
        temp = head;
        while (temp != null) {
            Node x = hm.get(temp);
            x.random = hm.get(temp.random);
            temp = temp.next;
        }

        return dummy.next;
    }
}

// https://leetcode.com/problems/copy-list-with-random-pointer/