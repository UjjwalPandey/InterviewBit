/*
    Letter Phone
    Given a digit string, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

    Input: Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    Make sure the returned strings are lexicographically sorted.
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {
    public static void main(String[] args) {
        String a = "23";
        String b = "375";
        System.out.println(letterCombinations(a));
        System.out.println(letterCombinations(b));
    }
    static ArrayList<String> result;

    public static ArrayList<String> letterCombinations(String A) {
        result = new ArrayList<>();
        HashMap<String, String> phoneButton = new HashMap<>();
        phoneButton.put("0","0");
        phoneButton.put("1","1");
        phoneButton.put("2","abc");
        phoneButton.put("3","def");
        phoneButton.put("4","ghi");
        phoneButton.put("5","jkl");
        phoneButton.put("6","mno");
        phoneButton.put("7","pqrs");
        phoneButton.put("8","tuv");
        phoneButton.put("9","wxyz");

        recursion(A,phoneButton,"");
        return result;
    }

    private static void recursion(String a, HashMap<String, String> phoneButton, String outputStr) {
        String digit = String.valueOf(a.charAt(0));
        String btnLetter = phoneButton.get(digit);
        if(a.length()==1){
            for(int i=0; i< btnLetter.length(); i++) {
                result.add(outputStr + btnLetter.charAt(i));
            }
            return ;
        }
        for(int i=0; i < btnLetter.length(); i++){
            recursion(a.substring(1) , phoneButton, outputStr+btnLetter.charAt(i));
        }
    }
}
