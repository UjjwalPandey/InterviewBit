/*  Given a list of non negative integers, arrange them such that they form the largest number.
    For example: Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

    Note: The result may be very large, so you need to return a string instead of an integer.
 */
package Array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(3);
        a1.add(30);
        a1.add(34);
        a1.add(5);
        a1.add(9);
        System.out.println(largestNumber(a1));

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(9);
        a2.add(99);
        a2.add(999);
        a2.add(9999);
        a2.add(9998);
        System.out.println(largestNumber(a2));

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(472);
        a3.add(29);
        a3.add(298);
        a3.add(722);
        a3.add(485);
        a3.add(852);
        a3.add(4);
        a3.add(635);
        a3.add(368);
        a3.add(676);
        a3.add(319);
        a3.add(412);
        System.out.println(largestNumber(a3));
    }

    public static String largestNumber(final List<Integer> A){
        StringBuilder result = new StringBuilder();

        ArrayList<String> res = new ArrayList<>();

        for(int x : A) res.add(String.valueOf(x));

        res.sort((listOne, listTwo) -> {
            String s1 = listOne+listTwo;
            String s2 = listTwo+listOne;
            return (s1.compareTo(s2));
        });

        System.out.println(res);
        for(int i =  res.size()-1; i>= 0; i--){
            result.append(res.get(i));
        }
        BigInteger b1 = new BigInteger(result.toString());
        return b1.toString();
    }
}
