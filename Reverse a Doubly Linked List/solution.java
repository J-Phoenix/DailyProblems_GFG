/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        if (head == null) return null; // empty list
        
        Node current = head;
        Node temp = null;
        
        while (current != null) {
            // Swap next and prev
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            
            // Move to next node (which is previous before swap)
            current = current.prev;
        }
        
        // After the loop, temp points to the previous node of null, i.e., new head
        if (temp != null) {
            head = temp.prev;
        }
        
        return head;
    }
}
