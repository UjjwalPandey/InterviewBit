package LinkedList;

public class ReverseAlternateKNodes {
    /* Linked list ListNode*/
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
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next.next = new ListNode(7);
        l.next.next.next.next.next.next.next = new ListNode(8);
        l.next.next.next.next.next.next.next.next = new ListNode(9);
        l.next.next.next.next.next.next.next.next.next = new ListNode(10);
        printLL(l);
        ListNode res = reverse(l, 4);
        printLL(res);
    }

    static ListNode reverse(ListNode node, int k) {
        ListNode current = node;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            node.next = reverse(next, k);
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
