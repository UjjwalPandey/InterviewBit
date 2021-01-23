/**
 *
 */
package ProgrammingRounds.nike;

import java.util.HashMap;
import java.util.Stack;

public class Solution2 {
    static HashMap<Character, Character> bracesMapping = new HashMap<>();
    public static void main(String[] args) {
        bracesMapping.put('(', ')');
        bracesMapping.put('{', '}');
        bracesMapping.put('[', ']');
        System.out.println(isValidParenthesis("()"));
        System.out.println(isValidParenthesis("    "));
        System.out.println(isValidParenthesis("[()"));
        System.out.println(isValidParenthesis("[()]"));
        System.out.println(isValidParenthesis("[(a)]"));
        System.out.println(isValidParenthesis(")][("));
        System.out.println(isValidParenthesis("[(])"));
        System.out.println(isValidParenthesis(null));
        System.out.println(isValidParenthesis(""));
        System.out.println(isValidParenthesis("[])"));
        System.out.println(isValidParenthesis("[({{{([])}}})]"));
    }

    private static boolean isValidParenthesis(String str) {

        if(str == null) return false;
        int N = str.length();
        if(N < 2) return false;
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()){
            boolean isOpening = isopeningBraces(ch);
            boolean isClosing = isclosingBraces(ch);
            if(!(isOpening || isClosing)) return false;     // Any different character
            if(isOpening){
                stack.push(ch);
            }else {
                if(stack.isEmpty()) return false;
                char topBracket = stack.peek();
                if(bracesMapping.get(topBracket) != ch){
                    return false;
                }else{
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
    }

    private static boolean isopeningBraces(char ch){
        return ((ch == '(') || (ch == '{') || (ch == '['));
    }

    private static boolean isclosingBraces(char ch){
        return ((ch == ')') || (ch == '}') || (ch == ']'));
    }
}
