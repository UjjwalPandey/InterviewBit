/** Fina GCD(a,b)
 * You are given a number P and a number Q.
 * Greatest Common Divisor (GCD) of all numbers between P and Q inclusive is taken (GCD(P, P+1, P+2 ... Q)).
 * As this problem looks a bit easy, it is given that numbers P and Q can be in the range of 10100. You have to return the value of GCD found.
 * Greatest common divisor of 2 numbers A and B is the largest number D that divides both A and B perfectly.
 */

import java.math.BigInteger;
public class GCD {
    public static void main(String[] args) {
        int A = 34967436, B= 40689075;
        String a = "00035", b ="00030";
        System.out.println("GCD = "+gcd(A,B));
        System.out.println("GCD BigInteger = "+gcdBigInt(a,b));
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        if(b > a){
            int temp = b;
            b = a;
            a = temp;
        }
        return gcd(b,a%b);

    }
    public static String gcdBigInt(String a, String b){
        BigInteger b1 = new BigInteger(a);
        BigInteger b2 = new BigInteger(b);
        if(b2.compareTo(BigInteger.ZERO) == 0){
//            System.out.println("Leading Zeros= "+BigInteger.);
            return b1.toString();
        }
        if(b2.compareTo(b1) == 1){
            BigInteger temp = b2;
            b2 = b1;
            b1 = temp;
        }
        System.out.println("B1= "+b1+", B2= "+b2);
        BigInteger mod = b1.mod(b2);
//        System.out.println("Mod = "+mod);
        return gcdBigInt(b2.toString(),mod.toString());
    }
}
