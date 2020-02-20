/*  Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall,
    and an integer B which represent the number of cows.
    His cows don't like this barn layout and become aggressive towards each other once put into a stall.
    To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible.
    What is the largest minimum distance?


    Problem Constraints
    2 <= N <= 100000
    0 <= A[i] <= 10^9
    2 <= B <= N


    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.


    Output Format
    Return the largest minimum distance possible among the cows.


    Example Input
    A = [1, 2, 3, 4, 5]
    B = 3


    Example Output
    2


    Example Explanation
    John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
    So the minimum distance will be 2.

 */
package Binary_Search;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
//        int[] A = {1, 2, 3, 4, 5};  // 2
//        int B = 3;
        int[] A = {0, 1000000000}; // 1000000000
        int B = 2;

        int[] C = { 82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95 }; // 7
        int D = 8;
        System.out.println(minDistance(A,B));
        System.out.println(minDistance(C,D));
    }

    public static int minDistance(int[] A, int B) {
        Arrays.sort(A);
        int N = A.length;
        int start=0,end=A[N-1],max=-1;
        while (end>=start) {
            int mid=(start+end)/2;
//            System.out.println("Mid = "+mid+" Max = "+max+" Start =  "+start+" End = "+end);
            if (check(mid,A,B)==1) {
                if (mid>max){
                    max=mid;
                }
                start=mid+1;
            }
            else
                end=mid;
            if(start == mid && mid==end) break;
        }
        return max;
    }
    public static int check(int num,int stalls[], int B) {
        int cows=1,pos=stalls[0], N = stalls.length;
        for (int i=1; i<N; i++) {
            if (stalls[i]-pos>=num) {
                pos=stalls[i];
                cows++;
                if (cows==B)
                    return 1;
            }
        }
        return 0;
    }

}
