package Binary_Search;

import java.util.Arrays;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] A = {{1, 3, 5},{2, 6, 9},{3, 6, 9}};
        int[][] B = {{2},{1},{4},{1},{2},{2},{5}};
        int[][] C = {{1},{3},{4},{1},{2},{4},{4},{4},{2},{2},{1}};
        System.out.println(findMedian_BinarySearch(A));
        System.out.println(findMedian_BinarySearch(B));
        System.out.println(findMedian_BinarySearch(C));
    }
    public static int findMedian_BinarySearch(int[][] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int N = A.length;
        int M = A[0].length;
        int size = M*N, median_pos;
        if(size%2 != 0) {
            median_pos = (size+1)/2;
        }else {
            median_pos = size/2;
        }

        for(int i=0; i<N ; i++){
            min = Math.min(A[i][0] , min);
            max = Math.max(A[i][M-1] , max);
        }
        while(min < max){
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            // Elements smaller than mid
            for(int i = 0; i < N; ++i){
                get = Arrays.binarySearch(A[i],mid);
                // (-(insertion_point) - 1) output when element not found
                if(get < 0)
                    get = Math.abs(get) - 1;
                else{
                    // Including the Duplicate values
                    while(get < A[i].length && A[i][get] == mid)
                        get += 1;
                }
                place = place + get;
            }
            if (place < median_pos)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static int findMedian_BruteForce_N_power_4(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int size = M*N, median_pos;
        if(size%2 != 0) {
            median_pos = (size+1)/2;
        }else {
            median_pos = size/2;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int lesserNum =0, sameNumber =0;
                for (int k=0; k<N; k++){
                    for(int l =0; l<M; l++){
                        if(A[i][j] > A[k][l])
                            lesserNum++;
                        else if(A[i][j] == A[k][l])
                            sameNumber++;

                    }
                }
//                System.out.println("A[i][j] = "+A[i][j]+"  LesserNumber = "+lesserNum+" same number "+sameNumber+" median pos = "+median_pos);
                if(lesserNum == median_pos-1) return A[i][j];
                if(lesserNum < median_pos && (lesserNum+sameNumber) >= median_pos) return A[i][j];
            }
        }
        return 0;
    }
}
