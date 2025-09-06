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
    public int lengthOfLoop(Node head) {
        // code here
        if (head == null) return 0;

        Node slow = head, fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // loop detected
                return countLoopLength(slow);
            }
        }
        return 0; // no loop
    }

    // Step 2: Count loop length
    private int countLoopLength(Node nodeInLoop) {
        int count = 1;
        Node temp = nodeInLoop.next;

        while (temp != nodeInLoop) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
