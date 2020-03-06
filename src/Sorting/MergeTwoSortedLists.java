/*  Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists,
    and should also be sorted. For example, given following linked lists :

      5 -> 8 -> 20
      4 -> 11 -> 15
    The merged list should be :
    4 -> 5 -> 8 -> 11 -> 15 -> 20

 */
package Sorting;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(20);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(15);

        printList(l1);
        printList(l2);
        ListNode merged = mergeTwoLists(l1, l2);
        printList(merged);
        ListNode merged2 = mergeTwoListsTLE(l1, l2);
        printList(merged2);
    }

    private static void printList(ListNode l1) {
        ListNode temp = l1;
        while (temp != null){
            System.out.print(temp.val+"  ->  ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode first, ListNode second) {
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
    public static ListNode mergeTwoListsTLE(ListNode A, ListNode B) {
        ListNode res = null;
        while(A != null && B != null){
            if(A.val < B.val){
                res = insert(res,A.val);
                A = A.next;
            }else{
                res = insert(res,B.val);
                B = B.next;
            }
        }
        while(A != null){
            res = insert(res,A.val);
            A = A.next;
        }
        while(B != null){
            res = insert(res,B.val);
            B = B.next;
        }
        return res;
    }

    public static ListNode insert(ListNode list, int data){
        ListNode new_node = new ListNode(data);
        new_node.next = null;

        if (list == null) {
            list = new_node;
        }else {
            ListNode last = list;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

}

