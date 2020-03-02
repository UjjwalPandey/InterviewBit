/*
    Find if Given number is power of 2 or not.
    More specifically, find if given number can be expressed as 2^k where k >= 1.

    Input:

    number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
    Output:

    return 1 if the number is a power of 2 else return 0

    Example:

    Input : 128
    Output : 1
 */
package Strings;

import java.math.BigInteger;

public class PowerOf2 {
    public static void main(String[] args) {
        String[] str = {"8","9","1024","87654364867897098", "-1", "1"};
        for(String s: str) System.out.println(power(s));
    }

    public static int power(String A) {
        BigInteger num = new BigInteger(A);
        if(num.compareTo(new BigInteger("2")) == -1) return 0;
        int count ;
        count = num.bitCount();
        if(count == 1) return  1;
        return 0;
    }
}
