/*  Length of longest palindromic list

    Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list. Note: A palindrome list is a list that reads the same backward and forward. Expected memory complexity : O(1)
    Input Format
    The only argument given is head pointer of the linked list.
    Output Format
    Return the length of the longest palindrome list.
    Constraints
    1 <= length of the linked list <= 2000
    1 <= Node value <= 100
    For Example
    Input 1:
        2 -> 3 -> 3 -> 3
    Output 1:
       3

    Input 2:
        A = 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
    Output 2:
        5

REFER:  https://www.geeksforgeeks.org/length-longest-palindrome-list-linked-list-using-o1-extra-space/
 */

package LinkedList;

public class LengthOfLongestPalindromicList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        ListNode l;
        l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next.next.next = new ListNode(4);
        printList(l);
        System.out.println(maxPalindrome(l));
    }

    private static int maxPalindrome(ListNode A) {
        int result = 0;
        ListNode prev = null, curr = A;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            result = Math.max(result, 2 * countCommon(prev, next)+1);

            result = Math.max(result, 2*countCommon(curr, next));

            prev = curr;
            curr = next;
        }
        return result;
    }

    // function for counting the common elements
    public static int countCommon(ListNode a, ListNode b){
        int count = 0;
        for (; a != null && b != null; a = a.next, b = b.next) {
            if (a.val == b.val)
                ++count;
            else
                break;
        }
        return count;
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
