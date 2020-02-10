package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Add_One_To_Number {
    public static void main(String[] args) {
//        int[] ip = { 9, 9, 9, 9, 9 };
        int[] ip = {0,2};
        int[] op = plusOne(ip);
        for (int i=0; i< op.length; i++)
            System.out.print(op[i]+" ");
    }

    public static int[] plusOne(int[] A) {
        int carry = 0;
        int i;
        int N = A.length;
        for(i=N-1; i >=0; i--){
            int sum;
            int val = A[i];
            if(i== N-1){
                sum = val+1;
            }else{
                sum = val+carry;
            }
//            System.out.println("i= "+i+" sum= "+sum+" val = "+val);
            A[i] = sum%10;
            carry = sum/10;
        }
        if(carry !=0){
//            System.out.println("Carry = "+carry);
            int[] res = new int[N+1];
            res[0] = carry;
            for (int j=1; j<N+1; j++){
                res[j] = A[j-1];
            }
            return res;
        }
        int initialZeros = 0;
        while (A[initialZeros] ==0){
            initialZeros++;
        }
        if(initialZeros != 0){
            int[] res = new int[N-initialZeros];
            for (int j=initialZeros; j<N; j++){
                res[j-initialZeros] = A[j];
            }
            return res;
        }
        return A;
    }
}
