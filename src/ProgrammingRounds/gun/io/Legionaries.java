/*
In the range 1 - 13 (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) the digit 1
occurs 6 times.

In the range, 1 - 2,660 (half the number of Romans in a legion), expressed in
Roman numerals, how many times does the numeral “X” occur?

 */
package ProgrammingRounds.gun.io;

import java.util.Scanner;

public class Legionaries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(solve(input));  // 2660 -> 3977
    }

    private static int solve(int A) {
        int count =0;
        for(int i=1; i <= A; i++){
            String roman = integerToRoman(i);
            for(int j=0; j < roman.length(); j++){
                if(roman.charAt(j) == 'X'){
                    count++;
                }
            }
        }
        return count;
    }

    private static String integerToRoman(int number) {
        int[] num = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] sym = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int i=12;
        StringBuilder res = new StringBuilder();
        while(number>0)
        {
            int div = number/num[i];
            number = number%num[i];
            while(div-- != 0){
                res.append(sym[i]);
            }
            i--;
        }
        return res.toString();
    }
}
