/* Remove Duplicates from Sorted List


Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
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
