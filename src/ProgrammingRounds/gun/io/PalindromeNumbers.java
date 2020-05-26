/*
Palindromes

A palindrome is a word, number, phrase, or another sequence of characters which
reads the same backward as forward, such as madam, racecar, or the number

What is the sum of all numeric palindromes that are less than 10,000?

 */

package ProgrammingRounds.gun.io;

import java.util.Scanner;

public class PalindromeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(solve(input));  // 10000 -> 545040
    }

    private static long solve(int input) {
        long sum =0;
        for(int i=1; i <= input; i++){
            if(isPalindrome(String.valueOf(i))){
                sum+= i;
            }
        }
        return sum;
    }

    private static boolean isPalindrome(String str) {
        int start =0, last = str.length()-1;
        while (start <= last){
            if(str.charAt(start) != str.charAt(last)){
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
}
