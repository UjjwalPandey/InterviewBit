package ProgrammingRounds.dunzo;

import java.util.ArrayList;

public class GetCoinOrEnergyInNumerousHouse {
    static int MAX_SIZE = 1001;

    public static void main(String[] args) {
        ArrayList<Integer> energy = new ArrayList<>();
        energy.add(2);
        energy.add(1);
        energy.add(1);
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(11);
        coins.add(5);
        coins.add(7);
        System.out.println(getRich(0, energy, coins));
    }
    static int getRich(long initialEnergy, ArrayList<Integer> energy, ArrayList<Integer> coins) {

        int[][] dp = new int[MAX_SIZE][MAX_SIZE];

        int n = energy.size();

        for(int i = n - 1; i >= 0; --i) {
            for(int e = 0; e <= n; ++e) {
                if(i == n - 1) {
                    dp[i][e] = coins.get(i);
                } else {

                    if(e - 1 >= 0) {
                        dp[i][e] = dp[i + 1][Math.min(e + energy.get(i) - 1, n)];
                        dp[i][e] = Math.max(dp[i][e], coins.get(i) + dp[i + 1][e - 1]);
                    }
                    if(e == 0) {
                        dp[i][e] = Math.max(dp[i][e], coins.get(i));
                    }
                }
            }
        }
        return dp[0][(int)Math.min((long)n, initialEnergy)];
    }
}
