/* Given an integer A, we call k >= 2 a good base of A, if all digits of A base k are 1. Now given a string representing A, you should return the smallest good base of A in string format.
    Input Format
        The only argument given is the string representing A.
    Output Format
        Return the smallest good base of A in string format.
    Constraints
        3 <= A <= 10^18
    For Example
        Input 1:
            A = "13"
        Output 1:
            "3"     (13 in base 3 is 111)

        Input 2:
            A = "4681"
        Output 2:
            "8"     (4681 in base 8 is 11111).


    Note: Refer http://www.programmersought.com/article/2334663706/
 */
package Binary_Search;

import java.math.BigInteger;

public class SmallestGoodBase {
    public static void main(String[] args) {
        String[] A = {"13","4681","40","41","1000000000000000000"};
//        String[] A = {"13","1000000000000000000"};
        for(String s: A) System.out.println(smallestGoodBase(s));

    }
    public static boolean judge(long num, long base){
        if(base == 1)
            return false;
        num -= 1;
        while(num > 0 && num % base == 0){
            num /= base;
            num -= 1;
        }
        return num == 0;
    }
    public static String smallestGoodBase(String A) {
        long num = Long.valueOf(A);
        long temp = num - 1;
        long res = temp;
        for(long i = 1; i <= Math.pow(num, 1.0 / 3); i++){
            if((temp) % i != 0)
                continue;
            if(judge(num, i))
                return String.valueOf(i);
            if(judge(num, (temp) / i))
                res = (temp) / i;
        }
        long root = (long) Math.sqrt(4 * num - 3);
        if(Math.pow(root, 2) == 4 * num - 3) {
            long cur = (-1 + root);
            if(cur != 2 && cur % 2 == 0)
                res = Math.min(cur / 2, res);
        }
        return String.valueOf(res);
    }


    public static String smallestGoodBase_BinarySearch(String A) {
        double val = Double.parseDouble(A);
        if(val < 1 ) {
            BigInteger neg = new BigInteger("18446744073709551615");
            return neg.subtract(BigInteger.ONE).toString();
        }
        double maxOnes = (int)(Math.log(val)/Math.log(2))+1;
//        System.out.println(maxOnes);
        for (int i =(int)maxOnes; i> 0; i--){
            double start =2, end =  val-1;
            while (start < end){
                double mid =  start + Math.floor((end-start)/2);
//                System.out.println(start+" -> "+mid+" -> "+end);
                if(mid == start || mid == end) break;
                double gp = GP(mid,i);
//                System.out.println(gp+" "+val);
                if(gp==val) {
                    if(mid < Integer.MAX_VALUE) {
                        return String.valueOf(new Double(mid).intValue());
                    }
                    BigInteger b = BigInteger.valueOf((long)val);
                    return b.toString();
                }
                if(gp > val) end = mid;
                if(gp < val) start = mid;
            }
        }
        if(val-1 < Integer.MAX_VALUE) {
            return String.valueOf(new Double(val-1).intValue());
        }
        BigInteger b = BigInteger.valueOf((long)val-1);
        return b.toString();
    }
    private static double GP(double i, double j) {
        return (Math.pow(i,j)-1)/(i-1);
    }

    public static String smallestGoodBaseO_10_pow_TC(String A) {
        double val = Double.parseDouble(A);
        double maxOnes = (int)(Math.log(val)/Math.log(2))+1;
        System.out.println(maxOnes);
        for(double i=2; i<val -1; i++){
            for(double j= maxOnes; j>0; j--){
                if(GP(i,j) == val){
                    return String.valueOf((int)i);
                }
            }
        }

        return String.valueOf((int)val-1);
    }
}
