package Array;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Arrange_Array_To_Form_Largest_Number {
    public static void main(String[] args) {
//        int[] a = {3, 30, 34, 5, 9};
//        int[] a = {0,0,0,0};
        int[] a = {12, 121, 3, 129};
        System.out.println(largestNumber(a));
    }

    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    public static String largestNumber(final int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargerNumberComparator());

//        if (asStrs[0].equals("0")) {
//            return "0";
//        }
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }
        BigInteger bi = new BigInteger(largestNumberStr);
        return bi.toString();

    }
}
