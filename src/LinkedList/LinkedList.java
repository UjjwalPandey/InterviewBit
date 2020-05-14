/*  Linked-List

    Problem Description
    Design and implement a Linked List data structure. A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:

    insert_node(position, value) - To insert the input value at the given position in the linked list.
    delete_node(position) - Delete the value at the given position from the linked list.
    print_ll() - Print the entire linked list, such that each element is followed by a single space.

    Note:
    If an input position does not satisfy the constraint, no action is required.
    Each print query has to be executed in new line.



    Problem Constraints
    1 <= position <= n where, n is the size of the linked-list.


    Input Format
    First line contains an integer denoting number of cases, let's say t.
    Next t line denotes the cases.


    Output Format
    When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
    NOTE: You don't need to return anything.


    Example Input
    5
    i 1 23
    i 2 24
    p
    d 1
    p


    Example Output
    23 24
    24


    Example Explanation
    After first two cases linked list contains two elements 23 and 24.
    At third case print: 23 24.
    At fourth case delete value at first position, only one element left 24.
    At fifth case print: 24.

 */
package LinkedList;

import java.util.Scanner;

public class LinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(){}

        ListNode(int x) { val = x; next = null; }
    }

    static ListNode node;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cases=0, position=0, value=0;
        cases = s.nextInt();
        for(int i=0; i<cases; i++) {
            char ch = s.next().charAt(0);
            switch(ch) {
                case 'i':
                    position = s.nextInt();
                    value = s.nextInt();
                    insert_node(position, value);
                    break;
                case 'd':
                    position = s.nextInt();
                    delete_node(position);
                    break;
                case 'p':
                    print_ll();
                    System.out.println();
                    break;
                default:
                    System.out.println("Check Your Input");
            }
        }
    }

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if(node == null && position == 1){
            node = new ListNode(value);
        }else if(position == 1){
            ListNode newl = new ListNode(value);
            newl.next = node;
            node = newl;
        }else{
            int i = 2;
            ListNode temp = node;
            while(i != position){
                if(temp == null) return;
                temp = temp.next;
                i++;
            }
            ListNode newl = new ListNode(value);
            newl.next = temp.next;
            temp.next = newl;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position == 1){
            node = node.next;
        }else{
            int counter = 1;
            ListNode temp = node;
            while(counter < position -1){
                counter++;
                if(temp.next == null) return;
                temp = temp.next;
            }
            if(temp.next == null) return;
            if(temp.next.next == null){
                temp.next = null;
                return;
            }
            temp.next = temp.next.next;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode temp = node;
        while(temp != null){
            if(temp.next == null){
                System.out.print(temp.val);
            }else {
                System.out.print(temp.val + " ");
            }
            temp = temp.next;
        }
//        System.out.println();
    }
}


/*      SAMPLE TEST CASE
100
i 1 226
i 2 875
i 3 604
i 4 550
i 5 498
i 6 875
i 7 847
i 8 633
i 9 793
i 10 872
i 11 313
i 12 440
i 13 331
i 14 582
i 15 188
i 16 476
i 17 722
i 18 402
i 19 890
i 20 713
i 21 421
i 22 930
i 23 579
i 24 459
i 25 278
i 26 818
i 27 320
i 28 549
i 29 240
i 30 528
i 31 367
i 32 835
i 33 20
i 34 170
i 35 903
i 36 242
i 37 943
i 38 802
i 39 145
i 40 291
i 41 224
i 42 400
i 43 43
i 44 355
i 45 83
i 46 26
i 47 816
i 48 477
i 49 425
i 50 543
i 51 211
i 52 799
i 53 185
i 54 5
i 55 184
i 56 150
i 57 572
i 58 626
i 59 109
i 60 807
d 25
p
d 53
p
d 12
d 54
p
p
p
p
p
d 39
d 42
p
d 47
d 45
d 35
p
d 13
p
d 18
d 59
d 47
d 43
d 38
p
p
p
p
p
p
d 8
p
d 8
p
d 39
d 60
d 16
p
p

 */

/*
200
i 1 4998
i 2 6629
i 3 7976
i 4 1445
i 5 6573
i 6 6416
i 7 2528
i 8 6208
i 9 7871
i 10 8738
i 11 9468
i 12 7983
i 13 6477
i 14 1214
i 15 8468
i 16 4793
i 17 5687
i 18 7074
i 19 430
i 20 3310
i 21 4005
i 22 3848
i 23 6598
i 24 2184
i 25 5350
i 26 201
i 27 952
i 28 2842
i 29 3564
i 30 8239
i 31 6513
i 32 6310
i 33 2195
i 34 4645
i 35 4237
i 36 4763
i 37 3786
i 38 1331
i 39 644
i 40 7022
i 41 4055
i 42 5940
i 43 7777
i 44 9343
i 45 5284
i 46 7284
i 47 9061
i 48 6201
i 49 4987
i 50 3808
i 51 8755
i 52 6335
i 53 2478
i 54 8615
i 55 4455
i 56 4466
i 57 4290
i 58 7744
i 59 5193
i 60 2801
i 61 3705
i 62 8208
i 63 7357
i 64 785
i 65 9765
i 66 7857
i 67 5365
i 68 5535
i 69 9190
i 70 8728
i 71 4598
i 72 242
i 73 8917
i 74 9501
i 75 6524
i 76 6305
i 77 5566
i 78 7105
i 79 3865
i 80 9204
i 81 6068
i 82 6423
i 83 2371
i 84 3519
i 85 4510
i 86 5354
i 87 9899
i 88 407
i 89 530
i 90 9102
i 91 8426
i 92 3926
i 93 686
i 94 8645
i 95 2445
i 96 2226
i 97 5199
i 98 1892
i 99 5012
i 100 9844
i 24 7114
d 5
 */