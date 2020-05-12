/*  List Cycle

    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    Try solving it using constant additional space.

    Example :

    Input :

                      ______
                     |     |
                     \/    |
            1 -> 2 -> 3 -> 4

    Return the node corresponding to node 3.



 */
package LinkedList;

public class ListCycle {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }


    public ListNode detectCycle(ListNode a) {
        if(a == null) return null;
        ListNode slow = a.next;
        if(a.next == null) return null;
        ListNode fast = a.next.next;
        // Check for the loop using slow and fast pointers
        while(true){
            if(fast == null || slow == null || fast == slow){
                break;
            }
            slow = slow.next;
            if(fast.next == null){
                fast = null;
                break;
            }
            fast = fast.next.next;
        }
        // If Loop not found return Null
        if(fast == null) return null;
        // If Loop found resume Fast pointer from its location and slow pointer from the start.
        // The meeting point will be the start of the cycle.
        if(fast == slow){
            slow = a;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }
}
