/*
    Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
    For corner elements, we need to consider only one neighbor.
    For example, for input array {5, 10, 20, 15}, 20 is the only peak element.
    Following corner cases give better idea about the problem.
    1) If input array is sorted in strictly increasing order, the last element is always a peak element.
        For example, 5 is peak element in {1, 2, 3, 4, 5}.
    2) If input array is sorted in strictly decreasing order, the first element is always a peak element.
        10 is the peak element in {10, 9, 8, 7, 6}.
 */
package Binary_Search;

public class Find_Peak_Element {
    public static void main(String[] args) {
        int[] A =  {5, 17, 100, 11};
        int[] B =  {1, 2, 3, 4, 5};
        int[] C =  {5,4,3,2,0};
        System.out.println(peakElement(A));
        System.out.println(peakElement(B));
        System.out.println(peakElement(C));
    }
    public static int peakElement(int[] A) {
        int N = A.length;
        if(N == 0) return -1;
        int peak = A[0];
        int i =1;
        while (i+1 < N){
            if(A[i] > A[i-1] && A[i] > A[i+1]){
                return A[i];
            }
            i++;
        }
        return Math.max(peak, A[i]);
    }
}
