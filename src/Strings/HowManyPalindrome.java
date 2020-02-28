package Strings;

import java.util.ArrayList;
import java.util.List;

public class HowManyPalindrome {
    public static void main(String[] args) {
        String s = "aa";
        List<Integer> lower = new ArrayList<>();
        lower.add(0);
        lower.add(1);
        lower.add(0);
        List<Integer> upper = new ArrayList<>();
        upper.add(0);
        upper.add(1);
        upper.add(1);
        System.out.println(howManyPalindromes(s,lower,upper));
    }

    public  static List<Long> howManyPalindromes(String s, List<Integer> lower, List<Integer> upper){
        List<Long> result = new ArrayList<>();
        int size = Math.min(lower.size(), upper.size());
        for(int i=0; i<size; i++){
            String str = s.substring(lower.get(i), upper.get(i)+1);
            long res = CountPS(str.toCharArray(), str.length());
            result.add(res);
            System.out.println("Substr = "+str+"  res = "+res+"  List = "+result);
        }
        return result;
    }

    static long CountPS(char[] str, int n) {
        if(str.length == 1) return 1;
        long[][] dp = new long[n][n];
        boolean[][] P = new boolean[n][n];

        for (int i= 0; i< n; i++)
            P[i][i] = true;

        for (int i=0; i<n-1; i++){
            if (str[i] == str[i+1])
            {
                P[i][i+1] = true;
                dp[i][i+1] = 1 ;
            }
        }

        for (int gap=2 ; gap<n; gap++) {
            for (int i=0; i<n-gap; i++) {
                int j = gap + i;
                if (str[i] == str[j] && P[i+1][j-1] )
                    P[i][j] = true;

                if (P[i][j])
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }
        return dp[0][n-1];
    }
}
