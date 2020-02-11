/** Print concentric rectangular pattern in a 2d matrix.
 Let us show you some examples to clarify what we mean.

 Example 1:

 Input: A = 4.
 Output:

 4 4 4 4 4 4 4
 4 3 3 3 3 3 4
 4 3 2 2 2 3 4
 4 3 2 1 2 3 4
 4 3 2 2 2 3 4
 4 3 3 3 3 3 4
 4 4 4 4 4 4 4
 Example 2:

 Input: A = 3.
 Output:

 3 3 3 3 3
 3 2 2 2 3
 3 2 1 2 3
 3 2 2 2 3
 3 3 3 3 3
 The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

 You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 *
 */
package Array;

public class Print_Concentric_Rectangular {
    public static void main(String[] args) {
        int N = 3;
        int[][] res =prettyPrint(N);
        for(int i=0; i< res.length; i++){
            for (int j=0; j< res.length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] prettyPrint(int A) {
        int len = 2*A-1;
        int[][] res = new int[len][len];
        for(int i=0; i< A; i++){
            setValues(res,A-i , i,len-i);
        }
        return res;
    }
    static void setValues(int[][] A, int val, int p1, int p2){
        int len = A.length;
        for(int i=p1; i< p2; i++){
            A[p1][i] = val;
            A[len-1-p1][i] = val;
        }
        for(int i=p1; i< p2; i++){
            A[i][p1] = val;
            A[i][len-1-p1] = val;
        }
    }
}
