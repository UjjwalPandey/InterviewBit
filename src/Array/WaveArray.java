package Array;

import java.util.Arrays;

/** Wave Array
 Given an array of integers, sort the array into a wave like array and return it, In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5..... Example
 Given [1, 2, 3, 4]

 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. So, in example case, you will return [2, 1, 4, 3]
 ×
*/
public class WaveArray {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
//        int[] A = {11, 8, 7, 9, 2, 10, 2 };
        printArray(A);
        printArray(wave(A));
    }

    private static void printArray(int[] A) {
        for(int i=0; i< A.length; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println();

    }

    public static int[] wave(int[] A) {
        Arrays.sort(A);
        int small = 0, bigger = -1;
        int len = A.length;
        while(small <len && bigger< len){
//            bigger = nextBig(A,small);
            bigger = small + 1;
            if(bigger < 0 || bigger >= len){
                break;
            }
            if(A[bigger] > A[small]){
                int temp = A[bigger];
                A[bigger] = A[small];
                A[small] = temp;
            }
            small = bigger+1;
        }
        return A;
    }
//    public static int nextBig(int[] A, int x){
//        int i = -1;
//        if(x+1 < A.length){
//            for (i = x + 1; i < A.length; i++) {
//                if (A[i] > A[x])
//                    return i;
//            }
//        }
//        return -1;
//    }
}
