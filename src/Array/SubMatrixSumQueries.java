package Array;

public class SubMatrixSumQueries {
    final static int VAL = 1000000007;
    public static int[][] preProcess(int[][] mat){
        int[][] sum = new int[mat.length][mat[0].length];
        sum[0][0] = mat[0][0];
        // pre-process first row
        for (int j = 1; j < mat[0].length; j++) {
            sum[0][j] = (mat[0][j]%VAL + sum[0][j - 1]%VAL)%VAL;
        }
        // pre-process first column
        for (int i = 1; i < mat.length; i++) {
            sum[i][0] = (mat[i][0]%VAL + sum[i - 1][0]%VAL)%VAL;
        }
        // pre-process rest of the matrix
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                sum[i][j] = (mat[i][j]%VAL + sum[i - 1][j]%VAL + sum[i][j - 1]%VAL
                        - sum[i - 1][j - 1]%VAL)%VAL;
            }
        }
        return  sum;
    }
    public static int findSubmatrixSum(int[][] sum, int p, int q, int r, int s) {
        int total = sum[r][s];
        if (q - 1 >= 0) {
            total = (total%VAL - sum[r][q - 1]%VAL)%VAL;
        }
        if (p - 1 >= 0) {
            total = (total%VAL - sum[p - 1][s]%VAL)%VAL;
        }
        if (p - 1 >= 0 && q - 1 >= 0) {
            total = (total%VAL + sum[p - 1][q - 1]%VAL)%VAL;
        }
        return (VAL + total)%VAL;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 0, 2, 5, 4, 1 },
                        { 4, 8, 2, 3, 7 },
                        { 6, 3, 4, 6, 2 },
                        { 7, 3, 1, 8, 3 },
                        { 1, 5, 7, 9, 4 }
                };
        int[] B = {1, 2};
        int[] C = {1, 2};
        int[] D = {2, 3};
        int[] E = {2, 3};

//        int p = 1, q = 1, r = 3, s = 3;

        int[][] sum = preProcess(mat);
//        for(int i=0; i<sum.length; i++){
//            for(int j=0; j<sum[0].length; j++){
//                System.out.print(sum[i][j]+" ");
//            }
//            System.out.println();
//        }
        // calculate sub-matrix sum
        for(int i=0; i< B.length; i++)
            System.out.println(findSubmatrixSum(sum, B[i]-1, C[i]-1,D[i]-1,E[i]-1));
    }
}
