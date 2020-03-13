/*  Given a array of integers A of size N and an integer B.
    Return number of non-empty subsequences of A of size B having sum <= 1000.

    Problem Constraints
        1 <= N <= 20 1 <= A[i] <= 1000 1 <= B <= N

    Input Format
        The first argument given is the integer array A. The second argument given is the integer B.

    Output Format
        Return number of subsequences of A of size B having sum <= 1000.

    Example Input
        Input 1:
            A = [1, 2, 8]
            B = 2
        Input 2:
            A = [5, 17, 1000, 11]
            B = 4

    Example Output
        Output 1:
        3
        Output 2:
        0

    Example Explanation
        Explanation 1:
         {1, 2}, {1, 8}, {2, 8}
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;

public class SIXLETS {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(8);
        int B = 2;
        System.out.println(sixlet(A,B));

        ArrayList<Integer> C = new ArrayList<>();
        C.add(5);
        C.add(17);
        C.add(1000);
        C.add(11);
        int D = 4;
        System.out.println(sixlet(C,D));
    }

    static int count;
    private static int sixlet(ArrayList<Integer> A, int B) {
        count = 0;
        getSixlet(A, B, 0);
        return count;
    }

    private static void getSixlet(ArrayList<Integer> A, int B, int sum) {
        if(B == 1){
            for(int x: A){
                if(sum+x <= 1000){
                    count++;
                }
            }
        }else{
            for(int i =0; i < A.size(); i++) {
                getSixlet(new ArrayList<>(A.subList(i+1, A.size())), B - 1, sum + A.get(i));
            }
        }
    }
}
