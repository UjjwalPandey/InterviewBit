package Bit_Manipulation;

public class XOR_Queries {
    public static void main(String[] args) {
        int[] A={1,0,0,0,1};
        int[][] B={{2,4},{1,5},{3,5}};
        int[][] res = solve(A,B);
        printArr(res);
    }

    public static int[][] solve(int[] A, int[][] B) {
        int[][] res = new int[B.length][2];
        for (int i=0; i<B.length; i++){
            int xor = A[B[i][0]-1];
            int zeroCount = 0;
            if(xor == 0) zeroCount++;
            for(int j= B[i][0]; j<=B[i][1]-1; j++){
                xor ^= A[j];
                if(A[j] == 0) zeroCount++;
            }
            res[i][0] = xor;
            res[i][1] = zeroCount;
        }

        return res;
    }

    static void printArr(int[][] res){
        for(int i=0; i<res.length; i++){
            for(int j =0; j<res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
