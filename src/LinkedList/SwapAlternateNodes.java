package LinkedList;

public class SwapAlternateNodes {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        printList(l);
        printList(swap(l));
        l.next = new ListNode(3);
        l.next.next = new ListNode(5);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(2);
        l.next.next.next.next.next = new ListNode(7);
        printList(l);
        printList(swap(l));
    }

    private static ListNode swap(ListNode l) {
        if(l == null || l.next == null) return l;
        ListNode slow = l, fast = l.next;
        while(fast != null){
            int temp = slow.val;
            slow.val = fast.val;
            fast.val = temp;
            slow = fast.next;
            if(slow == null) break;
            fast = slow.next;
        }
        return l;
    }

    private static void printList(ListNode removeNthFromEnd) {
        ListNode temp = removeNthFromEnd;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
