/*  B-th Smallest Prime Fraction

    Problem Description

    A sorted array of integers, A contains 1, plus some number of primes. Then, for every p < q in the list, we consider the fraction p/q.

    What is the B-th smallest fraction considered?

    Return your answer as an array of integers, where answer[0] = p and answer[1] = q.



    Problem Constraints

    1 <= length(A) <= 2000
    1 <= A[i] <= 30000
    1 <= B <= length(A)*(length(A) - 1)/2


    Input Format

    The first argument of input contains the integer array, A.
    The second argument of input contains an integer B.


    Output Format

    Return an array of two integers, where answer[0] = p and answer[1] = q.


    Example Input

    Input 1:

     A = [1, 2, 3, 5]
     B = 3

    Input 2:

     A = [1, 7]
     B = 1



    Example Output

    Output 1:

     [2, 5]

    Output 2:

     [1, 7]



    Example Explanation

    Explanation 1:

     The fractions to be considered in sorted order are:
     [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
     The third fraction is 2/5.

    Explanation 2:

     The fractions to be considered in sorted order are:
     [1/7]
     The first fraction is 1/7.
 */
package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5};
        int B = 3;
        System.out.println(Arrays.toString(findKthSmallestFraction(A,B)));
    }

    static class Fraction implements Comparable<Fraction>{
        int p, q;
        double fraction;
        Fraction(int a, int b){
            p = a;
            q = b;
            fraction = (((double)p)/q);
        }

        public double getFraction() {
            return fraction;
        }

        public int[] getNumDenom(){
            return new int[]{p,q};
        }

        @Override
        public String toString() {
            return "Fraction{" +
                    "p=" + p +
                    ", q=" + q +
                    ", fraction=" + fraction +
                    '}';
        }

        @Override
        public int compareTo(Fraction f) {
            return Double.compare(fraction, f.getFraction());
        }
    }

    private static int[] findKthSmallestFraction(int[] A, int B) {
        ArrayList<Fraction> frac= new ArrayList<>();
        frac.add(new Fraction(1,1));
        for(int i =0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                frac.add(new Fraction(A[i], A[j]));
            }
        }
        Collections.sort(frac);
        if(B >= frac.size()) return new int[]{0,0};
        return frac.get(B-1).getNumDenom();
    }
}
