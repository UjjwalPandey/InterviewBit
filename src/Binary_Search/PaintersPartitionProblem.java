/*
    Given 2 integers A and B and an array of integers C of size N. Element C[i] represents length of ith board.
    You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.
     Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
     Note:
        1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
        2. A painter will only paint contiguous boards. Which means a configuration where painter 1 paints board 1 and 3 but not 2 is invalid.

    Return the ans % 10000003.

    Problem Constraints
        1 <= A <= 1000
        1 <= B <= 10^6
        1 <= N <= 10^5
        1 <= C[i] <= 10^6


    Input Format
    The first argument given is the integer A.
    The second argument given is the integer B.
    The third argument given is the integer array C.


    Output Format
    Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.


    Example Input
        Input 1:
            A = 2
            B = 5
            C = [1, 10]
        Input 2:
            A = 10
            B = 1
            C = [1, 8, 11, 3]

    Example Output
        Output 1:
            50
        Output 2:
            11

    Example Explanation
    Explanation 1:
        Possibility 1:- same painter paints both blocks, time taken = 55 units.
        Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
        There are no other distinct ways to paint boards.
                ans = 50%10000003
 */

package Binary_Search;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int A = 10;
        int B = 1;
        int[]C = {1, 8, 11, 3};

        int D = 6;
        int E = 10;
        int[]F = {762, 798, 592, 899, 329 };

        int G = 4;
        int H = 10;
        int[]I = {884, 228, 442, 889}; //8890

        int J = 1;
        int K = 10;
        int[]L = {1000000, 1000000}; //9400003
        System.out.println(paint(A,B,C));
        System.out.println(paint(G,H,I));
        System.out.println(paint(D,E,F));
        System.out.println(paint(J,K,L));
    }

    public static int paint(int A, int B, int[] C) {
        int maxValue= Integer.MIN_VALUE, sum=0;
        for(int x: C){
            sum += x;
            maxValue = Math.max(x,maxValue);
        }
        long start=maxValue,end=sum,max=Integer.MIN_VALUE, mid=-1;
        while (end>=start) {
            mid=(start+end)/2;
            if (check(mid,C,A)==1) {
                max = Math.max(mid, max);
                start=mid+1;
            }else {
                end=mid;
            }
            if(start == mid && mid==end) break;
        }
        if(max == -1) return (int)((mid*B)%10000003);
        return (int)((max*B)%10000003);
    }


    public static int check(long num, int[] pages, int B) {
        int students=0, sum =0;
        for (int page : pages) {
            sum += page;
            if (sum >= num) {
                students++;
                sum = page;
                if (students == B || sum == num) {
                    return 1;
                }
            }
        }
        if (sum>=num) {
            return 1;
        }
        return 0;
    }
}
