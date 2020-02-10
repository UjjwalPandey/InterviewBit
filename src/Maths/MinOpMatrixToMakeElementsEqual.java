package Maths;

import java.util.Arrays;

/** Minimum operations of given type to make all elements of a matrix equal
 Given a matrix of integers A of size N x M and an integer B.
 In a single operation, B can be added to or subtracted from any element of the matrix.
 Find and return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 */
public class MinOpMatrixToMakeElementsEqual {
    public static void main(String[] args) {
//        int[][] A = {{0, 2, 8},{8, 2, 0},{0, 2, 8}};
//        int[][] A = {{5, 17, 100, 11},{0, 0,  2,   8}};
        int[][] A = {{4, 19, 100, 10},{1, 1, 4, 7}};
        int B = 3;
        int result = solve(A, B);
        System.out.println("Result: "+result);
    }
    public static int solve(int[][] A, int B) {
        int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;
        int res = 0;
        int M = A.length, N = A[0].length;
        int[] a = new int[M*N];
        int counter =0;
        for(int i=0; i<M; i++){
            for(int j=0; j< N; j++){
                if(A[i][j] > MAX){
                    MAX = A[i][j];
                }
                if(A[i][j] < MIN){
                    MIN = A[i][j];
                }
                a[counter++] = A[i][j];
            }
        }
        printArray(a);
        int median = getMedian(a);
        System.out.println("Median = "+median);
        for(int i=0; i<M; i++){
            for(int j=0; j< N; j++){
                if((A[i][j]-MIN)%B !=0){
                    return -1;
                }else{
                    res += Math.abs(A[i][j]-median)/B;
                }
            }
        }

        return res;
    }

    private static int getMedian(int[] a) {
        Arrays.sort(a);
        printArray(a);
        int len = a.length;
        if(len%2 !=0){
            return a[len/2];
        }else{
            return (a[(len-1)/2] + a[len/2])/2;
        }
    }

    private static void printArray(int[] x){
        for(int i=0; i<x.length; i++){
            System.out.print(x[i]+" ");
        }
        System.out.println();
    }
}
