package Maths;

public class Grid_Unique_Path {
    public static void main(String[] args) {
        int A = 2, B = 3;
        int C = 3, D = 3;
        int E = 3, F = 4;
        System.out.println(uniquePaths(A,B));
        System.out.println(uniquePaths(C,D));
        System.out.println(uniquePaths(E,F));
    }

    public static int uniquePaths(int A, int B) {
        int[] h = new int[A];
        int[] v = new int[B];
        h[0] = 1;
        v[0] = 1;
        int count_i =0;
        int count_j =0;
        for (int i=1; i< A; i++){
            for(int j=1; j<B; j++){
//                mat[i][j] = mat[i-1][j] + mat[i][j-1];
                h[count_i++] = h[i-1]+v[j-1];
                v[count_j++] = h[i-1]+v[j-1];
            }
        }
        return h[count_i]+v[count_j];
    }

    // Recursive Solution
    /*public static int uniquePaths(int A, int B) {
        if(A==1 || B==1) return 1;
        return uniquePaths(A-1,B)+uniquePaths(A,B-1);
    }*/


    // Memory-based solution
    /*public static int uniquePaths(int A, int B) {
        int[][] mat = new int[A][B];
        mat[0][0]=1;
        for(int i =0; i< A; i++){
            mat[i][0]= 1;
        }
        for(int i =0; i< B; i++){
            mat[0][i]= 1;
        }
        for (int i=1; i< A; i++){
            for(int j=1; j<B; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        return mat[A-1][B-1];
    }*/

}
