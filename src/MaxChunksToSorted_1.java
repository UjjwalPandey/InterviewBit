/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions),
 * and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 */

public class MaxChunksToSorted_1 {
    public static void main(String[] args) {
        int[] A = {1,0,2,3,4};
        int[] B = {4,3,2,1,0};
        int[] C = {1,2,0,3};
        int[] D = {1,0};
        int[] E = {1,0,2};
        System.out.println(maxChunksToSorted(A));
        System.out.println(maxChunksToSorted(B));
        System.out.println(maxChunksToSorted(C));
        System.out.println(maxChunksToSorted(D));
        System.out.println(maxChunksToSorted(E));
    }
    public static int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
            }
            System.out.println("Max = "+max+" i= "+i+"  Arr[i]"+arr[i]+"  Ans= "+ans);
        }
        return ans;
    }
}
