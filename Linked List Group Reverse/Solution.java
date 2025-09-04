/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
                if (head == null || k <= 1) return head;
        
        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;
        
        Node current = head;
        
        while (current != null) {
            Node groupStart = current;
            Node prev = null;
            int count = 0;
            
            // Reverse k nodes (or all remaining if < k)
            while (current != null && count < k) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
                count++;
            }
            
            // Connect previous group end to new head
            prevGroupEnd.next = prev;
            // Connect group start (which is now end) to the next group's start
            groupStart.next = current;
            
            // Move prevGroupEnd to the end of this group
            prevGroupEnd = groupStart;
        }
        
        return dummy.next;

    }
}
