/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return head;

        // Step 1: Count the number of nodes
        Node temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Step 2: Check if k is valid
        if (k > n) return head;

        // If kth node from start and end are same, no need to swap
        if (2 * k - 1 == n) return head;

        // Step 3: Find kth node from start and its previous node
        Node x_prev = null;
        Node x = head;
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }

        // Step 4: Find kth node from end and its previous node
        Node y_prev = null;
        Node y = head;
        for (int i = 1; i < n - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }

        // Step 5: Swap previous node's next pointers
        if (x_prev != null) x_prev.next = y;
        if (y_prev != null) y_prev.next = x;

        // Step 6: Swap next pointers of x and y
        Node tempNext = x.next;
        x.next = y.next;
        y.next = tempNext;

        // Step 7: Update head if needed
        if (k == 1) head = y;
        if (k == n) head = x;

        return head;
    }
}
