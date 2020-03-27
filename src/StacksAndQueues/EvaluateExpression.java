/*  Evaluate Expression

    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Input Format
    The only argument given is character array A.

    Output Format
    Return the value of arithmetic expression formed using reverse Polish Notation.

    For Example
    Input 1:
        A =   ["2", "1", "+", "3", "*"]
    Output 1:
        9
    Explaination 1:
        starting from backside:
        *: ( )*( )
        3: ()*(3)
        +: ( () + () )*(3)
        1: ( () + (1) )*(3)
        2: ( (2) + (1) )*(3)
        ((2)+(1))*(3) = 9

    Input 2:
        A = ["4", "13", "5", "/", "+"]
    Output 2:
        6
    Explaination 2:
        +: ()+()
        /: ()+(() / ())
        5: ()+(() / (5))
        1: ()+((13) / (5))
        4: (4)+((13) / (5))
        (4)+((13) / (5)) = 6

 */
package StacksAndQueues;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        String[] s1 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(s1));

        String[] s2 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s2));
    }

    static Stack<Integer> st = new Stack<>();
    public static int evalRPN(String[] A) {
        int n = A.length;
        for (int i=0; i< n; i++) {
            if ("*/-+".contains(A[i])) {
                int a = st.pop();
                int b = st.pop();

                if (A[i].equals("+")) {
                    st.push(b+a);
                }
                else if (A[i].equals("-")) {
                    st.push(b-a);
                }
                else if (A[i].equals("*")) {
                    st.push(b*a);
                }
                else {
                    st.push(b/a);
                }
            }
            else {
                st.push(Integer.parseInt(A[i]));
            }
        }

        return st.peek();
    }
}
