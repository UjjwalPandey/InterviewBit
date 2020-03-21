/*  Compare Version Numbers

    Compare two version numbers version1 and version2.
    If version1 > version2 return 1,
    If version1 < version2 return -1,
    otherwise return 0.
    You may assume that the version strings are non-empty and contain only digits and the . character. The . character does not represent a decimal point and is used to separate number sequences. For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision. Here is an example of version numbers ordering:
    0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

 */
package Strings;

import java.math.BigInteger;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.2","1.13.4"));
        System.out.println(compareVersion("1.13.5","1.13.4"));
        System.out.println(compareVersion("1.13.5","1.15"));
        System.out.println(compareVersion("1.13","1.13.8"));
        System.out.println(compareVersion("1.0","1"));
        System.out.println(compareVersion("44444444444444444444444444","44444444444444444444444444444"));
        System.out.println(compareVersion("4.44444444444444444444444444","44444444444444444444444444444"));
    }

    public static int compareVersion(String A, String B) {
        String[] partsA = A.split("\\.");
        String[] partsB = B.split("\\.");
        if(partsA.length==1 && partsB.length == 1){
            BigInteger b1 = new BigInteger(A);
            BigInteger b2 = new BigInteger(B);
            return b1.compareTo(b2);
        }
        int i;
        for(i =0; (i < partsA.length && i < partsB.length); i++){
            BigInteger b1 = new BigInteger(partsA[i]);
            BigInteger b2 = new BigInteger(partsB[i]);
            int res = b1.compareTo(b2);
            if(res != 0) return res;
        }
        if(i == partsA.length){
            while (partsB[i].equals("0")){
                i++;
                if(i== partsB.length) return 0;
            }
        }else if(i == partsB.length){
            while (partsA[i].equals("0")){
                i++;
                if(i== partsA.length) return 0;
            }
        }
        return Long.compare(partsA.length, partsB.length);
    }
}
