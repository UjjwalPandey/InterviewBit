package Bit_Manipulation;

import java.util.Arrays;

public class Min_XOR_Value {
    public static void main(String[] args) {
        int[] A = {0, 4, 7, 9};
        System.out.println(findMinXor(A));
    }
    public static int findMinXor(int[] A) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(A); // SORTING helped reducing the second loop as we need to find the minimum XOR value from the Array.
        for(int i=1; i< A.length; i++){
            min = Math.min((A[i] ^ A[i - 1]), min);
        }
        return min;
    }
}
