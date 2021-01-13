package Array;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
    public static void main(String[] args) {
        int[][] a = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        System.out.println(riverSizes(a));

        int[][] b = {{0}};
        System.out.println(riverSizes(b));

        int[][] c = {{1}};
        System.out.println(riverSizes(c));

        int[][] d = {{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}};
        System.out.println(riverSizes(d));

        int[][] e = {
                {1, 0, 0, 1},
                {1, 0, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 1, 0}};
        System.out.println(riverSizes(e));

        int[][] f = {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}};
        System.out.println(riverSizes(f));
    }
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) continue;
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    if(matrix[i][j-1] != 0){
                        matrix[i][j] = 1 + matrix[i][j-1];
                    }
                }
                else if(j == 0){
                    if(matrix[i-1][j] != 0){
                        matrix[i][j] = 1 + matrix[i-1][j];
                    }
                }else{
                    matrix[i][j] = matrix[i-1][j]+ matrix[i][j-1] + 1;
                }
            }
        }
        printArr(matrix);

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(i == matrix.length - 1 && j == matrix[0].length - 1){
                    if(matrix[i][j] != 0) result.add(matrix[i][j]);
                }else if(i == matrix.length - 1){
                    if(matrix[i][j] > matrix[i][j+1]) result.add(matrix[i][j]);
                } else if(j == matrix[0].length - 1){
                    if(matrix[i][j] > matrix[i+1][j]) result.add(matrix[i][j]);
                } else {
                    if(matrix[i][j] > matrix[i][j+1] && matrix[i][j] > matrix[i+1][j] ){
                        result.add(matrix[i][j]);
                    }
                }

            }
        }
        return result;
    }

    public static void printArr(int[][] arr){
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}

