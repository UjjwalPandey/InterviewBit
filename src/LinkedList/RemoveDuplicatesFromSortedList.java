/*  Remove Duplicates from Sorted List

    Problem Description
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Problem Constraints
    0 <= length of linked list <= 1000000

    Input Format
    First argument is the head pointer of the linked list.

    Output Format
    Return the head pointer of the linked list after removing all duplicates.

    Example Input
    Input 1:
    1->1->2
    Input 2:
    1->1->2->3->3

    Example Output
    Output 1:
    1->2
    Output 2:
    1->2->3

    Example Explanation
    Explanation 1:
    each element appear only once in 1->2.

 */
package LinkedList;

public class RemoveDuplicatesFromSortedList {
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
        ListNode temp = A;
        while (temp.next != null){
            ListNode similar = temp.next;
            while (temp.val == similar.val){
                similar = similar.next;
                if(similar == null) break;
            }
            temp.next = similar;
            temp = similar;
            if(temp == null) break;
        }
        return A;
    }
}
