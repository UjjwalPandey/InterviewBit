/*  Problem Description

Given a linked list A , reverse the order of all nodes at even positions.



Problem Constraints
1 <= Size of linked list <= 100000



Input Format
First and only argument is the head of the Linked-List A.



Output Format
Return the head of the new linked list.



Example Input
Input 1:

A = 1 -> 2 -> 3 -> 4
Input 2:

A = 1 -> 2 -> 3


Example Output
Output 1:

 1 -> 4 -> 3 -> 2
Output 2:

 1 -> 2 -> 3


Example Explanation
Explanation 1:

Nodes are positions 2 and 4 have been swapped.
Explanation 2:

No swapping neccassary here.

 *
 */

package LinkedList;

public class EvenReverse {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int d) {
            val = d;
            next = null;
        }
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
        l.next.next.next.next.next.next.next = new ListNode(8);
        l.next.next.next.next.next.next.next.next = new ListNode(9);
        l.next.next.next.next.next.next.next.next.next = new ListNode(10);
        printList(l);
        ListNode res = solve(l);
        printList(res);
    }

    public static ListNode solve(ListNode A) {
        if(A == null) return A;
        if(A.next == null) return A;
        if(A.next.next == null) return A;
        ListNode odd = A;
        ListNode even = A.next;
        ListNode prev = A;
        ListNode curr = A.next;
        while(curr != null){
            prev.next = curr.next;
            prev = curr;
            curr = curr.next;
        }

        // reverse even
        prev = null;
        curr = even;
        ListNode next = curr.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        // printList(odd);
        // printList(curr);
        even = curr;
        A = odd;
        int i= 1;
        next = null;
        while(odd != null && even != null){
            if(i%2 == 1){
                next = odd.next;
                odd.next = even;
                odd = next;
            }else{
                next = even.next;
                even.next = odd;
                even = next;
            }
            i++;
        }
        return A;
    }
    public static void printList(ListNode node){
        ListNode temp = node;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
