/*  Middle element of linked list

    Given a linked list of integers. Find and return the middle element of the linked list.
    Note: If there are N nodes in the linked list and N is even then return the (N/2+1)th element.
    Input Format
    The only argument given head pointer of linked list.
    Output Format
    Return the middle element of the linked list.
    Constraints
    1 <= length of the linked list <= 100000
    1 <= Node value <= 10^9
    For Example
    Input 1:
        1->2->3->4->5
    Output 1:
       3

    Input 2:
        A = 1->5->6->2->3->4
    Output 2:
        2

 */
package LinkedList;

public class MiddleElementOfLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next.next = new ListNode(7);
        printList(l);
        System.out.println(findMid(l));
    }

    private static int findMid(ListNode A) {
        ListNode fast = A, slow = A;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null) break;
        }
        return slow.val;
    }

    private static void printList(ListNode ll) {
        ListNode temp = ll;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
