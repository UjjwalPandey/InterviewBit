/*  Swap List Nodes in pairs
    
    Problem Description
    Given a linked list A, swap every two adjacent nodes and return its head. NOTE: Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
    
    Problem Constraints
    1 <= |A| <= 106
    
    Input Format
    The first and the only argument of input contains a pointer to the head of the given linked list.
    
    Output Format
    Return a pointer to the head of the modified linked list.
    
    Example Input
    Input 1:
    A = [1, 2, 3, 4]
    Input 2:
    A = [7, 2, 1]
    
    Example Output
    Output 1:
    [2, 1, 4, 3]
    Output 2:
    [2, 7, 1]
    
    Example Explanation
    In the first example [[1, 2], [3, 4]] are the adjacent nodes. Swapping them will result in [2, 1, 4, 3]. In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. 

 */
package LinkedList;

public class SwapListNodesInPair {
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
        printList(swapPairs(l));
    }

    private static void printList(ListNode ll) {
        ListNode temp = ll;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode swapPairs(ListNode l) {
        ListNode first = l;
        if(first.next == null) return first;
        ListNode second = first.next, prev = null;
        while(true){
            first.next = second.next;
            if(first == l){
                l = second;
            }else {
                prev.next = second;
            }
            second.next = first;
            prev = first;
            if(first.next == null) return l;
            first = first.next;
            if(first.next == null) return l;
            second = first.next;
        }
    }
}
