package ProgrammingRounds.hackerrank;

import java.util.Arrays;

public class Ula {
    public static void main(String[] args) {
        int[] a = {5,3,4,2,1};
        System.out.println(Kit_sol(a.length, a));
    }

    static int Kit_sol(int N, int[] arr){
        // Write code here
        int count =0;
        int sum = 0;
        for(int a: arr){
            sum += a;
        }
        Arrays.sort(arr);
        int temp =0;
        for(int i= N-1; i>=0; i--){
            temp += arr[i];
            count++;
            if(temp > sum/2){
                break;
            }
        }

        return count;
    }
}


