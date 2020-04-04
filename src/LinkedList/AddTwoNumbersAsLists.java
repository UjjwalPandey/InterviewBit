/*  ADD TWO NUMBERS AS LISTS

    You are given two linked lists representing two non-negative numbers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8

    342 + 465 = 807
    Make sure there are no trailing zeros in the output list
    So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

 */
package LinkedList;

public class AddTwoNumbersAsLists {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        ListNode l1, l2;
        l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        printList(l1);
        l2 = new ListNode(1);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList(l2);
        printList(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode resultHead = null, tempA = A, tempB = B, tempRes = null;
        int carry = 0;
        while(tempA != null && tempB != null){
            int a = tempA.val;
            int b = tempB.val;
            int sum = a+b+carry;
            carry = sum/10;
            sum = sum%10;
            if(resultHead == null){
                resultHead = new ListNode(sum);
                tempRes = resultHead;
            }else{
                tempRes.next = new ListNode(sum);
                tempRes = tempRes.next;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if(tempA == null){
            while (tempB != null){
                int b = tempB.val;
                int sum = b+carry;
                carry = sum/10;
                sum = sum%10;
                tempRes.next = new ListNode(sum);
                tempRes = tempRes.next;
                tempB = tempB.next;
            }
        }else {
            while (tempA != null){
                int b = tempA.val;
                int sum = b+carry;
                carry = sum/10;
                sum = sum%10;
                tempRes.next = new ListNode(sum);
                tempRes = tempRes.next;
                tempA = tempA.next;
            }
        }
        if(carry != 0){
            tempRes.next = new ListNode(carry);
        }

        return resultHead;
    }

    private static void printList(ListNode ll) {
        ListNode temp = ll;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
