package ProgrammingRounds.gun.io;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(fibonacci(input));  // 10000 -> 14328
    }

    private static long fibonacci(int N) {
        long sum =1;
        if(N < 1) return 0;
        int[] DP = new int[N+1];
        DP[1] = 1;
        for(int i=2; i<= N; i++){
            DP[i] = DP[i-1]+DP[i-2];
            if(DP[i]%2 == 1) sum+= DP[i];
            if(DP[i] >= N) return sum;
        }
        return sum;
    }
}
