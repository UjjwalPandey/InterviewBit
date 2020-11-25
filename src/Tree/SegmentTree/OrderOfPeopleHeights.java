/* Order of People Heights   https://www.interviewbit.com/problems/order-of-people-heights/
 *
 * Asked in:  Google
 * You are given the following :
 *
 * A positive number N
 * Heights : A list of heights of N persons standing in a queue
 * Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
 * You need to return list of actual order of persons’s height
 *
 * Consider that heights will be unique
 *
 * Example
 *
 * Input :
 * Heights: 5 3 2 6 1 4
 * InFronts: 0 1 2 0 3 2
 * Output :
 * actual order is: 5 3 2 1 6 4
 * So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.
 *
 * For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.
 *
 * You can do similar inference for other people in the list.
 */
package Tree.SegmentTree;

import java.util.Arrays;

public class OrderOfPeopleHeights {
    static int[] resultST;
    static int counter;
    public static int[] order(int[] heights, int[] frontCounts) {
        resultST = new int[heights.length];
        counter = 0;
        Person[] persons = new Person[heights.length];

        for (int i = 0; i < persons.length; i++)
            persons[i] = new Person(heights[i], frontCounts[i]);

        Arrays.sort(persons, (p1, p2) -> Integer.compare(p2.height, p1.height));

        Node root = new Node(persons[0]);

        for (int i = 1; i < persons.length; i++) {
            insert(root, persons[i]);
        }

        inOrderTraversal(root);
        return resultST;
    }


    private static void insert(Node root, Person p) {
        insert(root, p, p.frontCount);
    }

    private static void insert(Node root, Person p, int value) {
        if (value < root.value) { // should insert to the left
            if (root.left == null) {
                root.left = new Node(p);
            } else {
                insert(root.left, p, value);
            }
            root.value++; // Increase the current node value while descending left!
        } else { // insert to the right
            if (root.right == null) {
                root.right = new Node(p);
            } else {
                insert(root.right, p, value - root.value);
            }
        }
    }

    private static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        resultST[counter++] = root.person.height;
        inOrderTraversal(root.right);
    }

    private static class Node {
        Node left, right;
        int value;
        public final Person person;

        public Node(Person person) {
            this.value = 1;
            this.person = person;
        }
    }

    private static class Person {
        public final int height;
        public final int frontCount;

        Person(int height, int frontCount) {
            this.height = height;
            this.frontCount = frontCount;
        }
    }

    public static void main(String[] args) {
        int[] heights = {5, 3, 2, 6, 1, 4};
        int[] frontCounts = {0, 1, 2, 0, 3, 2};

        System.out.print(Arrays.toString(order(heights, frontCounts)));
    }
}
