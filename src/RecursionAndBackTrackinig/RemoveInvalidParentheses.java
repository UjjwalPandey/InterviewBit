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

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("))"));
        System.out.println(removeInvalidParentheses(")(()((((()(("));
        System.out.println(removeInvalidParentheses("()"));
        System.out.println(removeInvalidParentheses("())())((()((()"));
        System.out.println(removeInvalidParentheses("()()))))(())))"));
    }
    static ArrayList<String> result;
    static int max;

    public static ArrayList<String> removeInvalidParentheses(String s) {
        if(s==null)
            return result;
         result = new ArrayList<String>();
         max = 0;
        dfs(s, "", 0, 0);
        if(result.size()==0){
            result.add("");
        }

        return result;
    }

    public static void dfs(String left, String right, int countLeft, int maxLeft){
        if(left.length()==0){
            if(countLeft==0 && right.length()!=0){
                if(maxLeft > max){
                    max = maxLeft;
                }

                if(maxLeft==max && !result.contains(right)){
                    result.add(right);
                }
            }

            return;
        }

        if(left.charAt(0)=='('){
            dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);//keep (
            dfs(left.substring(1), right, countLeft, maxLeft);//drop (
        }else if(left.charAt(0)==')'){
            if(countLeft>0){
                dfs(left.substring(1), right+")", countLeft-1, maxLeft);
            }

            dfs(left.substring(1), right, countLeft, maxLeft);

        }else{
            dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
        }
    }
}