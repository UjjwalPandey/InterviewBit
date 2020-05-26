/*

Epigram on Failure

Given the following quote by Alan Perlis

    “Dealing with failure is easy: Work hard to improve. Success is also easy to
    handle: You’ve solved the wrong problem. Work hard to improve.”

Considering only the alphabetical characters, consonants having the value of
their ASCII codes, and vowels having the inverse value of their ASCII codes,
what is the sum of the sentence?

Example:
Taking the word “iffy”, the ASCII code of “i” is 105, it’s inverse is -105.
The ASCII value of ‘f’ is 102. The ASCII y of “y” is 121. The sum of “iffy” =
220

 */
package ProgrammingRounds.gun.io;

import java.util.Scanner;

public class Ascii {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solve(str));
//        System.out.println(solve("Dealing with failure is easy: Work hard to improve. Success is also easy to handle: You’ve solved the wrong problem. Work hard to improve."));
        // 2865
//        System.out.println(solve("iffy"));
    }

    private static int solve(String A) {
        int sum =0;
        char[] C = A.toCharArray();
        for(char ch: C){
            if(Character.isAlphabetic(ch)){
                if(isVowel(ch)){
                    sum -= ch;
                }else {
                    sum += ch;
                }
            }
        }
        return sum;
    }

    private static boolean isVowel(char ch) {
        return ((ch == 'A') || (ch == 'E') || (ch == 'I') || (ch == 'O') || (ch == 'U') ||
                (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u'));
    }
}
