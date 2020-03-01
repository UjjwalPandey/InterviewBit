package Binary_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FindSmallestAgain {
    public static void main(String[] args) {
        int[] A = {18, 23, 11, 16, 5, 23, 7, 20, 20, 10};
        int B = 105; //57
        int[] C = {22, 10, 5, 11, 16, 2, 11, 7, 16, 2, 17, 6, 15, 3, 9, 6 };
        int D = 183;   //25
//        System.out.println(solve(C, D));
        System.out.println(solve_O_NCube(A,B));
    }

    private static int solve(int[] A, int B) {
        int minValue= Integer.MAX_VALUE, sum=0;
        for(int x: A){
            sum += x;
            minValue = Math.min(x,minValue);
        }
        long start=minValue,end=sum,max=Integer.MIN_VALUE, mid=-1;
        while (end>=start) {
            mid=(start+end)/2;
            if (check(mid,A,B)==1) {
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



    private static int solve_O_NCube(int[] A, int B) {
        int len = A.length;
        Arrays.sort(A);
        for(int x: A) System.out.print(x+"  ");
        System.out.println();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i < len; i++){
            for(int j = i+1; j< len; j++){
                for(int k = j+1; k< len; k++){
                    int sum = A[i]+A[j]+A[k];
                    temp.add(sum);
                }
            }
        }
        Collections.sort(temp);
//        System.out.println(temp);
        return temp.get(B-1);
    }
}
