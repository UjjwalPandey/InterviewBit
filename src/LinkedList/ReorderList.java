/*  Reorder List

    Problem Description
    Given a singly linked list A
     A: A0 → A1 → … → An-1 → An
    reorder it to:
     A0 → An → A1 → An-1 → A2 → An-2 → …
    You must do this in-place without altering the nodes' values.

    Problem Constraints
    1 <= |A| <= 106

    Input Format
    The first and the only argument of input contains a pointer to the head of the linked list A.

    Output Format
    Return a pointer to the head of the modified linked list.

    Example Input
    Input 1:
     A = [1, 2, 3, 4, 5]
    Input 2:
     A = [1, 2, 3, 4]

    Example Output
    Output 1:
     [1, 5, 2, 4, 3]
    Output 2:
     [1, 4, 2, 3]

    Example Explanation
    In the first example, the array will be arranged to [A0, An, A1, An-1, A2].
    In the second example, the array will be arranged to [A0, An, A1, An-1].

 */
package LinkedList;

public class ReorderList {
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
        printList(reorderList(l));
    }

    public static ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) return A;
        int l = getLength(A);
        int count = 1;
        int stop = l%2 == 0 ? l/2 : l/2 + 1;
        ListNode curr = A;
        while(count < stop) {
            curr = curr.next;
            count++;
        }

        ListNode half = reverseList(curr.next);
        curr.next = null;

        curr = A;
        while (half != null) {
            ListNode temp = new ListNode(half.val);
            temp.next = curr.next;
            curr.next = temp;

            curr = curr.next.next;
            half = half.next;
        }

        return A;
    }

    public static ListNode reverseList(ListNode A) {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = A;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static int getLength(ListNode A) {
        int l = 0;
        while (A != null) {
            A = A.next;
            l++;
        }

        return l;
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
