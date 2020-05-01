/* Merge K Sorted Lists

    Problem Description

    Given a list containing head pointers of N sorted linked lists. Merge these N given sorted linked lists and return it as one sorted list.


    Problem Constraints

    1 <= total number of elements in given linked lists <= 100000


    Input Format

    First and only argument is a list containing N head pointers.


    Output Format

    Return a pointer to the head of the sorted linked list after merging all the given linked lists.


    Example Input

    Input 1:

     1 -> 10 -> 20
     4 -> 11 -> 13
     3 -> 8 -> 9

    Input 2:

     10 -> 12
     13
     5 -> 6



    Example Output

    Output 1:

     1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

    Output 2:

     5 -> 6 -> 10 -> 12 ->13



    Example Explanation

    Explanation 1:

     The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.

    Explanation 2:

     The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

 */
package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        ArrayList<ListNode> A = new ArrayList<>();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(10);
        l1.next.next = new ListNode(20);
        A.add(l1);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(13);
        A.add(l2);
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(8);
        l3.next.next = new ListNode(9);
        A.add(l3);

        ListNode res = mergeKLists(A);
        while (res != null){
            System.out.print(res.val+"  -> ");
            res = res.next;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode l: a){
            ListNode temp = l;
            while (temp != null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        ListNode head = null, temp = null;
        while(pq.size() != 0){
            if(head == null){
                head = new ListNode(pq.poll());
                temp = head;
            }else{
                temp.next = new ListNode(pq.poll());
                temp = temp.next;
            }
        }
        return head;
    }
}
