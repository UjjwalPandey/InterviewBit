/*  Reverse Link List II
Asked in:
Facebook
Microsoft
Amazon
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1.2.3.4.5.null, m = 2 and n = 4,

return 1.4.3.2.5.null.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 *
 *
 */
package LinkedList;

public class reverseBetween {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
            next = null;
        }
    }
    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        printLL(l);
//        printLL(reverse(l, 1, 1));
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        printLL(l);
        printLL(reverse(l, 2, 3));
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next.next = new ListNode(7);
        l.next.next.next.next.next.next.next = new ListNode(8);
        l.next.next.next.next.next.next.next.next = new ListNode(9);
        l.next.next.next.next.next.next.next.next.next = new ListNode(10);
        printLL(l);
        ListNode res = reverse(l, 3, 10);
        printLL(res);
    }

    private static ListNode reverse(ListNode head, int m, int n) {
        if (m == n)
            return head;

        ListNode revs = null, revs_prev = null;
        ListNode revend = null, revend_next = null;

        int i = 1;
        ListNode curr = head;
        while (curr != null && i <= n) {
            if (i < m)
                revs_prev = curr;

            if (i == m)
                revs = curr;

            if (i == n) {
                revend = curr;
                revend_next = curr.next;
            }

            curr = curr.next;
            i++;
        }
        revend.next = null;

        revend = reverseSubList(revs);

        if (revs_prev != null)
            revs_prev.next = revend;
        else
            head = revend;

        revs.next = revend_next;
        return head;
    }

    static ListNode reverseSubList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    private static void printLL(ListNode l) {
        while(l != null){
            System.out.print(l.data+" -> ");
            l = l.next;
        }
        System.out.println();
    }
}
