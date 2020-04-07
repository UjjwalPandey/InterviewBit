/*  Remove Duplicates from Sorted List II

    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.

 */
package LinkedList;

public class RemoveDuplicatesFromSortedList_II {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next.next = new ListNode(4);
        printList(l);
        printList(deleteDuplicates(l));
        l.next.next.next.next.next.next.next = new ListNode(4);
        printList(l);
        printList(deleteDuplicates(l));
    }

    private static void printList(ListNode ll) {
        ListNode temp = ll;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode A) {
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode prev = dummy;
        ListNode current = A;

        while (current != null) {
            while (current.next != null && prev.next.val == current.next.val)
                current = current.next;


            if (prev.next == current){
                prev = prev.next;
            }else{
                prev.next = current.next;
            }

            current = current.next;
        }
        A = dummy.next;
        return A;
    }
}
