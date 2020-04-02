/*  Reverse Link List II

    Problem Description
    Reverse a linked list A from position B to C. NOTE: Do it in-place and in one-pass.


    Problem Constraints
    1 <= |A| <= 106 1 <= B <= C <= |A|


    Input Format
    The first argument contains a pointer to the head of the given linked list, A. The second arugment contains an integer, B. The third argument contains an integer C.


    Output Format
    Return a pointer to the head of the modified linked list.


    Example Input
    Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2
    C = 4
    Input 2:
    A = [1, 2, 3, 4, 5]
    B = 1
    C = 5


    Example Output
    Output 1:
    [1, 4, 3, 2, 5]
    Output 2:
    [5, 4, 3, 2, 1]


    Example Explanation
    In the first example, we want to reverse the highlighted part of the given linked list : [1, [2, 3, 4], 5]. Thus, the output is [1, 4, 3, 2, 5]. In the second example, we want to reverse the highlighted part of the given linked list : [[1, 2, 3, 4, 5]]. Thus, the output is [5, 4, 3, 2, 1].

 */
package LinkedList;

public class ReverseLinkedList_II {
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
        printList(reverseBetween(l, 2, 6));
        printList(reverseBetween(l, 3, 5));
        printList(reverseBetween(l, 4, 4));
        printList(reverseBetween(l, 1, 7));
    }

    private static void printList(ListNode ll) {
        ListNode temp = ll;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        int counter = 1;
        ListNode prevB = null, startB= A;
        while (counter < B){
            counter++;
            prevB = startB;
            startB = startB.next;
            if(startB == null) return A;
        }

        ListNode nextC = prevB, endC= startB;
        while (counter < C){
            counter++;
            nextC = endC;
            if(endC.next == null) break;
            endC = endC.next;
        }
        nextC = endC.next;

        ListNode rev_curr = startB, rev_pre = null;
        while (rev_curr != nextC){
            if(rev_curr == startB){
                rev_pre = rev_curr;
                rev_curr = rev_curr.next;
                rev_pre.next = endC.next;
            }else{
                ListNode next = rev_curr.next;
                rev_curr.next = rev_pre;
                rev_pre = rev_curr;
                rev_curr = next;
            }
        }

        if(prevB != null){
            prevB.next = endC;
        }else{
            A = endC;
        }

        return A;
    }
}
