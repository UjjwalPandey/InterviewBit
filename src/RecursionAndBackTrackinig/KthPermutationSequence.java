/*  Kth Permutation Sequence
    The set [1,2,3,…,n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3 ) :
    1. "123"
    2. "132"
    3. "213"
    4. "231"
    5. "312"
    6. "321"

    Given n and k, return the kth permutation sequence. For example, given n = 3, k = 4, ans = "231"

    Good questions to ask the interviewer :
    What if n is greater than 10. How should multiple digit numbers be represented in string?
     In this case, just concatenate the number to the answer. so if n = 11, k = 1, ans = "1234567891011"
    Whats the maximum value of n and k?
    In this case, k will be a positive integer that's less than INT_MAX.
    n is reasonable enough to make sure the answer does not bloat up a lot.

 */
package RecursionAndBackTrackinig;

public class KthPermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(5,7));
        System.out.println(getPermutation(3,2));
    }

    public static String getPermutation(int A, int B) {
        int[] arr = new int[A];
        for(int i =1; i<= A; i++){
            arr[i-1] = i;
        }
        int[] kPerm = kthPermutation(arr,B);
        StringBuilder str = new StringBuilder();
        for(int x: kPerm){
            str.append(x);
        }
        return str.toString();
    }

    private static int[] kthPermutation(int[] arr, int b) {
        for(int i =1; i<b; i++){
            nextPermutation(arr);
            printArr(arr);
       }
       return arr;
    }

    private static void printArr(int[] res) {
        for(int x: res){
            System.out.print(x+"  ");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] A) {
        if (A.length < 2)
            return;
        int last = A.length - 2;

        while (last >= 0) {
            if (A[last] < A[last + 1]) {
                break;
            }
            last--;
        }

        if (last < 0) {
//            Arrays.sort(A);
            return;
        }
        int nextGreater = A.length - 1;

        for (int i = A.length - 1; i > last; i--) {
            if (A[i] > A[last]) {
                nextGreater = i;
                break;
            }
        }

        int temp = A[nextGreater];
        A[nextGreater] = A[last];
        A[last] = temp;
        int left = last+1;
        int right = A.length-1;
        while (left < right) {
            int val = A[left];
            A[left++] = A[right];
            A[right--] = val;
        }
    }
}
