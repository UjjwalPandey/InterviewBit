/*  Palindrome List

    Problem Description
    Given a singly linked list A, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.


    Problem Constraints
    1 <= |A| <= 105


    Input Format
    The first and the only argument of input contains a pointer to the head of the given linked list.


    Output Format
    Return 0, if the linked list is not a palindrome. Return 1, if the linked list is a palindrome.


    Example Input
    Input 1:
    A = [1, 2, 2, 1]
    Input 2:
    A = [1, 3, 2]


    Example Output
    Output 1:
     1
    Output 2:
     0


    Example Explanation
    The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form. The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].

 */
package LinkedList;

import java.util.Stack;

public class PalindromeList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        printList(l);
        System.out.println(lPalin(l));
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next.next = new ListNode(4);
        printList(l);
        System.out.println(lPalin(l));
    }

    private static void printList(ListNode ll) {
        ListNode temp = ll;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int lPalin(ListNode A) {
        Stack<Integer> stack = new Stack<>();
        int N =0;
        ListNode temp = A;
        while (temp != null){
            N++;
            temp = temp.next;
        }
        temp = A;
        int mid = N/2, counter =1;
        boolean isOdd = N % 2 == 1;
//        System.out.println("Size = "+N+"  Mid = "+mid+" isOdd = "+isOdd);
        while (temp != null){
            int x = temp.val;
            if(counter <= mid){
//                System.out.println(stack+"   Pushing   "+x+"  Counter = "+counter);
                stack.push(x);
            } else if(counter == mid+1){
                if(isOdd){
                    counter++;
                    temp = temp.next;
                    continue;
                }else {
//                    System.out.println(stack+"   Checking   "+x+"  Counter = "+counter);
                    if (stack.peek() == x) {
                        stack.pop();
                    } else {
                        return 0;
                    }
                }
            }else {
                if(stack.peek() == x){
                    stack.pop();
                }else {
                    return 0;
                }
            }
            temp = temp.next;
            counter++;
        }
        return 1;
    }
}
