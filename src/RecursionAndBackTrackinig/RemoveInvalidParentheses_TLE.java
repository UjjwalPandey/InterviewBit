/*  Given a string A consisting of lowercase English alphabets and parentheses '(' and ').
    Remove the minimum number of invalid parentheses in order to make the input string valid.
    Return all possible results. You can return the results in any order.

     Input Format
    The only argument given is string A.

    Output Format
    Return all possible strings after removing the minimum number of invalid parentheses.

    Constraints
    1 <= length of the string <= 20

    For Example
    Input 1:
        A = ""()())()"
    Output 1:
         ["()()()", "(())()"]
         Explanation 1:
            By removing 1 parentheses we can make the string valid.
                    1. Remove the parentheses at index 4 then string becomes : "()()()"
                    2. Remove the parentheses at index 2 then string becomes : "(())()"



    Input 2:
        A = "(a)())()"
    Output 2:
        ["(a)()()", "(a())()"]

 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveInvalidParentheses_TLE {
    public static void main(String[] args) {
//        System.out.println(removeParenthesis("(a)())()"));
//        System.out.println(removeParenthesis("()())()"));
//        System.out.println(removeParenthesis("))"));
//        System.out.println(removeParenthesis(")(()((((()(("));
//        System.out.println(removeParenthesis("()"));
//        System.out.println(removeParenthesis("())())((()((()"));
        System.out.println(removeParenthesis("()()))))(())))"));
    }

    static HashSet<String> res;
    static int maxSize;
    public static ArrayList<String> removeParenthesis(String A) {
        res = new HashSet<>();
        maxSize = Integer.MIN_VALUE;
        int initialRemover = 0;
        while(A.charAt(initialRemover)==')'){
            A = A.substring(1);
            if(A.length() == 0) return new ArrayList<>();
        }
        while(A.charAt(A.length()-1)=='('){
            int len = A.length();
            A = A.substring(0, len-1);
            if(A.length() == 0) return new ArrayList<>();
        }

        findAllPermuatations(A);
        return new ArrayList<>(res);
    }

    private static void findAllPermuatations(String str) {
        if(str.length() < maxSize) return;
        if(isValid(str)){
            if(!str.isEmpty()){
                addToResult(str);
            }
        }else{
            for(int i=0; i< str.length(); i++){
                String  prefix = str.substring(0,i);
                String residuary = prefix+str.substring(i+1);

                if(isValid(residuary) && residuary.length() >= maxSize){
                    addToResult(residuary);
                }else if(maxSize < residuary.length()){
                    System.out.println("maxSize < residuary.length()");
                    findAllPermuatations(residuary);
                }
            }
        }
    }

    private static void addToResult(String str) {
                System.out.println("Str Length = "+str.length()+"  MAX = "+maxSize);
        if(str.length() == maxSize) {
            res.add(str);
        }else if (str.length() > maxSize){
                    System.out.println("NEW MAX =  "+str);
            res = new HashSet<>();
            res.add(str);
        }
        maxSize = str.length();
    }

    public static boolean isValid(String str){
        int count = 0;
        for(int i =0; i< str.length(); i++){
            if(str.charAt(i) == '('){
                count++;
            }else if(str.charAt(i) == ')'){
                count--;
            }
            if(count < 0) return false;
        }
        if(count != 0) return false;

        return true;
    }
}
