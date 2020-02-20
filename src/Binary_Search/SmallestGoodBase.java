package Binary_Search;

import java.math.BigInteger;

public class SmallestGoodBase {
    public static void main(String[] args) {
        String[] A = {"13","4681","40","41","1000000000000000000"};
//        String[] A = {"13","1000000000000000000"};
        for(String s: A) System.out.println(smallestGoodBase(s));

    }
    public static String smallestGoodBase(String A) {
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
