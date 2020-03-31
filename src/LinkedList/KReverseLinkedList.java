/*      K reverse linked list

    Problem Description
    Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return modified linked list.


    Problem Constraints
    1 <= |A| <= 103 K always divides A


    Input Format
    The first argument of input contains a pointer to the head of the linked list. The second arugment of input contains the integer, B.


    Output Format
    Return a pointer to the head of the modified linked list.


    Example Input
    Input 1:
     A = [1, 2, 3, 4, 5, 6]
     B = 2
    Input 2:
     A = [1, 2, 3, 4, 5, 6]
     B = 3



    Example Output
    Output 1:
     [2, 1, 4, 3, 6, 5]
    Output 2:
     [3, 2, 1, 6, 5, 4]



    Example Explanation
    Explanation 1:
     For the first example, the list can be reversed in groups of 2.
        [[1, 2], [3, 4], [5, 6]]
     After reversing the K-linked list
        [[2, 1], [4, 3], [6, 5]]
    Explanation 2:
     For the second example, the list can be reversed in groups of 3.
        [[1, 2, 3], [4, 5, 6]]
     After reversing the K-linked list
        [[3, 2, 1], [6, 5, 4]]

 */
package LinkedList;

public class KReverseLinkedList {
    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        KReverseLinkedList llist = new KReverseLinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
}

