/*  FIND SUB-ARRAY WITH THE GIVEN SUM

    Given an array of positive integers A and an integer B,
    find and return first continuous subarray which adds to B. If the answer does not exist return an array with a single element "-1".
    Note: First sub-array means the sub-array for which starting index in minimum.

    Input Format
        The first argument given is the integer array A.
        The second argument given is integer B.

    Output Format
        Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

    Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 10^9
        1 <= B <= 10^9
    For Example
        Input 1:
            A = [1, 2, 3, 4, 5]
            B = 5
        Output 1:
            [2, 3]

        Input 2:
            A = [5, 10, 20, 100, 105]
            B = 110
        Output 2:
            [-1]

 */
package Hashing;

public class FindSubArrayWithTheGivenSum {
    public static void main(String[] args) {
        int[] A = {1, 1000000000};
        int B = 1000000000;
        int[] res = getSubArray(A,B);
        for(int x: res) System.out.print(x+" , ");
        int[] C = { 42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37 };
        int D = 100;
        int[] res2 = getSubArray(C,D);
        for(int x: res2) System.out.print(x+" , ");
        int[] E = {1, 2, 3, 4, 5};
        int F = 5;
        int[] res1 = getSubArray(E,F);
        for(int x: res1) System.out.print(x+" , ");
    }

    private static int[] getSubArray(int[] A, int B) {
        if(A.length == 0) return new int[]{-1};
        if(A.length == 1 && A[0] != B) return new int[]{-1};

        int start =0, end = 1, sum = A[0];
        while(end <  A.length && sum != B && start <= end){
            if (sum < B){
                sum += A[end];
                end++;
            }else{
                sum -= A[start];
                start++;
            }
        }
        if(sum == B){
//            System.out.println("Length = "+(end-start)+"  "+end+"  "+start);
            int[] res = new int[end-start];
            for(int i= start; i < end; i++){
                res[i-start] = A[i];
            }
            return res;
        }
        if(A[--end] == B){
            return new int[]{A[end]};
        }

        return new int[]{-1};
    }

}
