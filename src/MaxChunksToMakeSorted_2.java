/** Given an array of integers (not necessarily distinct) A, if we split the array into some number of "chunks" (partitions),
 * and individually sort each chunk.
 * After concatenating them, the result equals the sorted array. What is the most number of chunks we could have made?
 *
 * Input 1:
 *     A = [3, 2, 3, 4, 0]
 * Output 1:
 *     1
 *
 * Input 2:
 *     A = [2, 0, 1, 2]
 * Output 2:
 *     2
 */
public class MaxChunksToMakeSorted_2 {
    public static void main(String[] args) {
//        int[] arr = {2,0,1,2};
        int[] arr = {3, 2, 3, 4, 0};
        System.out.println(maxChunks(arr));
    }

    private static int maxChunks(int[] arr) {
        int[] min = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            min[i] = i == arr.length - 1 ? arr[i]:Math.min(arr[i], min[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = i == 0 ? arr[i]:Math.max(max, arr[i - 1]);
            int realMax = i == 0 ? Integer.MIN_VALUE:max;
            if (min[i] >= realMax) count++;
        }
        return count;
    }

}
