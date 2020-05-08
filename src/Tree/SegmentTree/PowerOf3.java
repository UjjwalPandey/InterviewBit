/*   Power of 3

    Problem Description

    Given a binary string A of size N and an integer matrix B of size Q x 3.

    Matrix B has Q queries:

        For queries of type B[i][0] = 1, flip the value at index B[i][1] in A if and only if the value at that index is 0 and return -1.
        For queries of type B[i][0] = 0, Return the value of the binary string from index B[i][1] to B[i][2] modulo 3.

        Note: Rows are numbered from top to bottom and columns are numbered from left to right.

    Problem Constraints

    1 <= N <= 100000
    1 <= Q <= 200000
    1 <= B[i][1], B[i][2] <= N
    B[i][1] <= B[i][2]


    Input Format

    The first argument given is the string A.
    The second argument given is the integer matrix B of size Q * 3.


    Output Format

    Return an array of size Q where ith value is answer to ith query.


    Example Input

    Input 1:

     A = 10010
     B = [  [0, 3, 5]
            [0, 3, 4]
            [1, 2, -1]
            [0, 1, 5]
         ]

    Input 2:

     A = 11111
     B = [
            [0, 2, 4]
            [1, 2, -1
            [0, 2, 4]]
         ]



    Example Output

    Output 1:

     [2, 1, -1, 2]

    Output 2:

     [1, -1, 1]



    Example Explanation

    Explanation 1:

     For query 1, binary string from index 3 to 5 is 010 = 2. So 2 mod 3 = 2.
     For query 2, binary string from index 3 to 4 is 01 = 1. So 1 mod 3 = 1.
     After query 3, given string changes to 11010.
     For query 4, binary string from index 1 to 5 is 11010 = 26. So 26 mod 3 = 2.
     So, output array is [2, 1, -1, 2].

    Explanation 2:

     For query 1, binary string from index 2 to 4 is 111 = 7. So 7 od 3 = 1.
     After query 2, string remains same as there is already 1 at index 2.
     For query 3, binary string from index 2 to 4 is 111 = 7. So 7 od 3 = 1.
     So, output array is [1, -1, 1].


 */
package Tree.SegmentTree;

import java.util.Arrays;

public class PowerOf3 {
    public static void main(String[] args) {
        String A = "10010";
        int[][] B = {{0, 3, 5},
                {0, 3, 4},
                {1, 2, -1},
                {0, 1, 5}};
        System.out.println(Arrays.toString(solve(A,B)));

    }

    public static int[] solve(String A, int[][] B) {
        int n = A.length();
        int[] result = new int[B.length];
        int[] segment_tree = new int[4*n];
        build(A,segment_tree,1,1,n);
        for(int i=0;i<B.length;i++){
            if(B[i][0]==1){
                update(segment_tree,1,1,n,B[i][1]);
                result[i] = -1;
            }
            else{
                result[i] = calc(segment_tree,1,1,n,B[i][1],B[i][2]);
            }
        }
        return result;
    }
    static void build(String A,int[] st,int s_id,int start,int end){
        if(start==end){
            st[s_id]= A.charAt(start-1)-'0';
            return;
        }
        int mid = start + (end-start)/2;
        build(A,st,2*s_id,start,mid);
        build(A,st,2*s_id+1,mid+1,end);
        if((end-mid)%2==0)
            st[s_id] = (st[2*s_id]+st[2*s_id+1])%3;
        else
            st[s_id] = (2*st[2*s_id]+st[2*s_id+1])%3;
    }
    static void update(int[] st,int s_id,int start,int end,int req){
        if(start==end){
            st[s_id] = 1;
            return;
        }
        int mid = start+(end-start)/2;
        if(req<=mid){
            update(st,2*s_id,start,mid,req);
        }
        else{
            update(st,2*s_id+1,mid+1,end,req);
        }
        if((end-mid)%2==0)
            st[s_id] = (st[2*s_id]+st[2*s_id+1])%3;
        else
            st[s_id] = (2*st[2*s_id]+st[2*s_id+1])%3;
    }
    static int calc(int[] st,int s_id,int start,int end,int reql,int reqr){
        if(start==end){
            return st[s_id];
        }
        if(start==reql && end==reqr){
            return st[s_id];
        }
        int mid = start + (end-start)/2;
        if(reql<=mid&&reqr<=mid){
            return calc(st,2*s_id,start,mid,reql,reqr);
        }
//        else if(reql<=mid && reqr>mid){
        else if(reql<=mid){
            int l = calc(st,2*s_id,start,mid,reql,mid);
            int r = calc(st,2*s_id+1,mid+1,end,mid+1,reqr);
            if((reqr-mid)%2==0)
                return (l+r)%3;
            else
                return (2*l+r)%3;
        }
        else{
            return calc(st,2*s_id+1,mid+1,end,reql,reqr);
        }
        //return 0;
    }
}
