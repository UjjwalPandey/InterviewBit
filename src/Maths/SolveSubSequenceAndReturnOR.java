package Maths;

/** Solve sub-sequences and return OR
 A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.
 For example, the sequence {2, 3, 5} is a subsequence of {1, 2, 3, 4, 5} obtained after removal of elements {1, 4}.
 Given is an array of integers A of size N. An array of size N can have (2^N - 1) number of non empty subsequences.
 For the given function:

         solve (int subsequence[]) {
             int count[];    //array initialised to 0.
             for(int i = 0; i < subsequence.length; i++) {
                 number = subsequence[i];
                 for(int j = 2; j <= number; j++) {
                     if(number % j == 0) {
                         count[j]++;
                         if(count[j] == subsequence.length)  return 0;
                     }
                 }
             }
             return 1;
         }
 If all the subsequences of the array A are passed in the above function.
 What will be the *bitwise OR* of all the returned values from the given function

 Input 1:
 A = [1, 2, 3]
 Output 1:
 1

 Input 2:
 A = [2, 4, 6, 8]
 Output 2:
 0

 Note:  Here catch for the function is to find CO-PRIME numbers in the given array. If there is any such set, function will return 1.
 This will automatically gives 1 on Bitwise OR operation.
 */

public class SolveSubSequenceAndReturnOR {
    public static void main(String[] args) {
        int[] Arr = {1,4,7};
        System.out.println(solve(Arr));
    }
    public static int solve(int[] A) {
        // Arrays.sort(A);
        // for(int i=0; i<A.length; i++){
        //     for(int j =0; j< A.length; j++){
        int i =0, j = A.length-1;
        while(i<=j){
            // Check if A[i] and A[j] are coPrime. If so then the given function will return 1.
            // Thus it will make entire Bitwise OR operation to 1.
            if((A[i]%2 !=0 || A[j]%2 != 0) || (A[i]%3 != 0 && A[j]%3 !=0)|| (A[i]%5 != 0 && A[j]%5 !=0)){
                if(gcd(A[i],A[j]) == 1)
                    return 1;
            }
            i++; j--;
        }
        return 0;
    }
    public static int gcd(int a, int b){
        if (a == 0){ return b;}
        else if(b == 0){
            return a;

        }
        if (a == b)
            return a;
        if (a > b)
            return gcd(a%b, b);
        return gcd(a, b%a);
    }
}
