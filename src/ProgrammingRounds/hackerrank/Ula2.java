package ProgrammingRounds.hackerrank;

import java.util.Arrays;
import java.util.Collections;

public class Ula2 {
    public static void main(String[] args) {
        System.out.println(modifyString(13, "Khokharnikunj"));
    }

    private static String modifyString(int N, String str) {
        StringBuffer prime = new StringBuffer();
        StringBuffer composite = new StringBuffer();
        for(int i=0; i<N; i++){
            if(isPrime((int)str.charAt(i))){
                prime.append(str.charAt(i));
            }else {
                composite.append(str.charAt(i));
            }
        }
        char[] primeArr = prime.toString().toCharArray();
        Arrays.sort(primeArr);
        char[] compArr = composite.toString().toCharArray();
        Arrays.sort(compArr);
        return new String(primeArr)+new StringBuilder(new String(compArr)).reverse().toString();
    }

    private static boolean isPrime(int n) {
        for(int i=2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
