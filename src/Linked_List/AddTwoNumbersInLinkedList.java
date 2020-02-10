package Linked_List;/* Adding two numbers. Provided both the numbers are given in linked list. And they are in reverse order.
 *
 * L1: [7, 4, 3]
 * L2: [4, 7, 8, 9]
 * Output: [1, 0, 2, 2, 1]
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbersInLinkedList {
    private static LinkedList<Integer> SumTwoLinkedList(LinkedList<Integer> l1, LinkedList<Integer> l2){
        LinkedList<Integer> sum = new LinkedList<>();
        int size1 = l1.size();
        int size2 = l2.size();
        int carry =0;
        int counter = 0;
        while((counter < size1) && (counter < size2)){
            int x = l1.get(counter) + l2.get(counter)+carry;
            sum.push(x%10);
            carry = x/10;
            counter++;
        }
        if(size1 > size2){
            while(counter < size1){
                int x = l1.get(counter)+carry;
                sum.push(x%10);
                carry = x/10;
                counter++;
            }
        }else{
            while(counter < size2){
                int x = l2.get(counter)+carry;
                sum.push(x%10);
                carry = x/10;
                counter++;
            }
        }
        if(carry>0){
            sum.push(carry);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr1 = {7,4,3};
        int[] arr2 = {4,7,8,9};

        LinkedList l1 = ArrayToLinkedList(arr1);
        LinkedList l2 = ArrayToLinkedList(arr2);
        System.out.println("L1: "+l1.toString());
        System.out.println("L2: "+l2.toString());
        System.out.println(SumTwoLinkedList(l1, l2).toString());
    }

    private static LinkedList ArrayToLinkedList(int[] arr) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = arr.length;
        for(int i =0; i< len; i++){
            res.add(arr[i]);
        }
        return  res;
    }
}
