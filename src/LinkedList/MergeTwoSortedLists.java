/*  Problem Description

        Merge two sorted linked lists A and B and return it as a new list.
        The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.


        Problem Constraints
        0 <= |A|, |B| <= 105


        Input Format
        The first argument of input contains a pointer to the head of linked list A. The second argument of input contains a pointer to the head of linked list B.


        Output Format
        Return a pointer to the head of the merged linked list.


        Example Input
        Input 1:
        A = [5, 8, 20]
        B = [4, 11, 15]
        Input 2:
        A = [1, 2, 3]
        B = []


        Example Output
        Output 1:
        [4, 5, 8, 11, 15, 20]
        Output 2:
        [1, 2, 3]

 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

package LinkedList;

public class MergeTwoSortedLists {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode third = null;
        ListNode last = third;

        if(first==null) return second;
        if(second==null) return first;


        if(first.val < second.val) {
            third = last = first;
            first = first.next;
            last.next = null;
        }
        else{
            third = last = second;
            second = second.next;
            last.next = null;
        }
        while(first!=null && second!=null) {
            if(first.val < second.val){
                last.next = first;
                last = first;
                first = first.next;
                last.next = null;
            }
            else {
                last.next = second;
                last = second;
                second = second.next;
                last.next = null;
            }
        }
        if(first!=null) last.next = first;
        else last.next = second;

        return third;
    }
}
