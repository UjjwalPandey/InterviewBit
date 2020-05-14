/*
Sort List

    Asked in:
    Google

    Sort a linked list in O(n log n) time using constant space complexity.

    Example :

    Input : 1 -> 5 -> 4 -> 3

    Returned list : 1 -> 3 -> 4 -> 5



 */
package LinkedList;

public class SortList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        l.next = new ListNode(3);
        l.next.next = new ListNode(5);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(2);
        printList(l);
        printList(sort(l));
    }

    private static void printList(ListNode removeNthFromEnd) {
        ListNode temp = removeNthFromEnd;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode sort(ListNode A) {
        ListNode tail = A;
        while (tail.next != null){
            tail = tail.next;
        }
        return mergeSort(A,tail);
    }

    private static ListNode mergeSort(ListNode head, ListNode tail) {
        if(head == tail){
            return new ListNode(head.val);
        }
        ListNode mid = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            mid = mid.next;
            fast = fast.next.next;
            if(fast == null) break;
        }
        if(mid == tail) return new ListNode(head.val);
        ListNode left = mergeSort(head, mid);
        ListNode right = mergeSort(mid.next, tail);
        return merger(left, right);
    }

    private static ListNode merger(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode res = null;
        while (left != null && right != null){
            if(left.val < right.val){
                if(head == null){
                    head = left;
                    res = head;
                }else{
                    head.next = left;
                    head = head.next;
                }
                left = left.next;
                head.next = null;
            }else{
                if(head == null){
                    head = right;
                    res = head;
                }else{
                    head.next = right;
                    head = head.next;
                }
                right = right.next;
                head.next = null;
            }
        }
        if(left == null){
            while (right != null){
                if(head == null){
                    head = right;
                    res = head;
                }else{
                    head.next = right;
                    head = head.next;
                }
                right = right.next;
                head.next = null;
            }
        }else {
            while (left != null){
                if(head == null){
                    head = left;
                    res = head;
                }else{
                    head.next = left;
                    head = head.next;
                }
                left = left.next;
                head.next = null;
            }
        }
        return res;
    }
}
