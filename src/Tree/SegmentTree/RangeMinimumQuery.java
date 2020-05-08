/*  Range Minimum Query

    Problem Description

    Given an integer array A of size N.

    You have to perform two types of query, in each query you are given three integers x,y,z.

    If x = 0, then update A[y] = z.
    If x = 1, then output the minimum element in the array A between index y and z inclusive.

    Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.



    Problem Constraints

    1 <= N, M <= 105

    1 <= A[i] <= 109

    If x = 0, 1<= y <= N and 1 <= z <= 109

    If x = 1, 1<= y <= z <= N



    Input Format

    First argument is an integer array A of size N.

    Second argument is a 2-D array B of size M x 3 denoting queries.



    Output Format

    Return an integer array denoting the output of each query where value of x is 1.


    Example Input

    Input 1:

     A = [1, 4, 1]
     B = [
            [1, 1, 3]
            [0, 1, 5]
            [1, 1, 2]
         ]

    Input 2:

     A = [5, 4, 5, 7]
     B = [
            [1, 2, 4]
            [0, 1, 2]
            [1, 1, 4]
         ]

    Example Output

    Output 1:

     [1, 4]

    Output 2:

     [4, 2]

    Example Explanation

    Explanation 1:

     For 1st query, the minimum element from range (1, 3) is 1.
     For 2nd query, update A[1] = 5, now A = [5, 4, 1].
     For 3rd query, the minimum element from range (1, 2) is 4.

    Explanation 2:

     For 1st query, the minimum element from range (2, 4) is 4.
     For 2nd query, update A[1] = 2, now A = [2, 4, 5, 7].
     For 3rd query, the minimum element from range (1, 4) is 2.
 */
package Tree.SegmentTree;

import java.util.Arrays;

public class RangeMinimumQuery {
    public static void main(String[] args) {
        int[] A = {1, 4, 1};
        int[][] B = {{1, 1, 3},
                    {0, 1, 5},
                    {1, 1, 2},
                    {0, 2, 6},
                    {1, 1, 2}};
        System.out.println(Arrays.toString(solve(A,B)));
        int[] C = new int[] {7, 2, 19, 24, 5, 24};
        int [][] D = new int[][]{
                {0, 1, 21},
                {0, 3, 12},
                {0, 1, 10},
                {0, 2, 18},
                {1, 1, 3}
        };
        System.out.println(Arrays.toString(solve(C, D)));
    }

    static int[] st;
    static int[] arrayElementInST;
    public static int[] solve(int[] A, int[][] B) {
        int resLen = 0;
        for (int[] ints : B) if (ints[0] == 1) resLen++;
        int[] res = new int[resLen];
        resLen =0;

        constructST(A,A.length);
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(st));
//        System.out.println(Arrays.toString(arrayElementInST));
        for (int[] arr : B){
            if(arr[0] == 0){
                A[arr[1]-1] = arr[2];
                update(A.length, arrayElementInST[arr[1]-1], arr[2]);
//                constructSTUtil(A, 0, A.length - 1, 0);
//                System.out.println(Arrays.toString(st));
            }else{
                res[resLen++] = RMQ(A.length, arr[1]-1, arr[2]-1);
            }
//            System.out.println(Arrays.toString(A));
        }
//        System.out.println(Arrays.toString(st));
        return res;
    }

    static void update(int n, int pos, int val) {
        st[pos] = val;
        do {
            int left = pos;
            int right = pos;
            if (pos % 2 == 1) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            pos = (pos%2 == 0)? (pos/2)-1 : pos/2;
            st[pos] = Math.min(st[left], st[right]);
        }while (pos != 0);
    }

    static void constructST(int[] arr, int n) {
        //Maximum size of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size]; // allocate memory
        arrayElementInST = new int[n]; // allocate memory

        constructSTUtil(arr, 0, n - 1, 0);
    }

    static int constructSTUtil(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            arrayElementInST[ss] = si;
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = Math.min(constructSTUtil(arr, ss, mid, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }


    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    static int RMQUtil(int ss, int se, int qs, int qe, int index) {
        if (qs <= ss && qe >= se)
            return st[index];

        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;

        int mid = getMid(ss, se);
        return Math.min(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    static int RMQ(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            return -1;
        }
        return RMQUtil(0, n - 1, qs, qe, 0);
    }
}
