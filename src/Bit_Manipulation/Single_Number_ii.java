/*
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?


 */
package Bit_Manipulation;

public class Single_Number_ii {
    public static void main(String[] args) {
//        int[] A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        int[] A = {890, 992, 172, 479, 973, 901, 417, 215, 901, 283, 788, 102, 726, 609, 379, 587, 630, 283, 10, 707, 203, 417, 382, 601, 713, 290, 489, 374, 203, 680, 108, 463, 290, 290, 382, 886, 584, 406, 809, 601, 176, 11, 554, 801, 166, 303, 308, 319, 172, 619, 400, 885, 203, 463, 303, 303, 885, 308, 460, 283, 406, 64, 584, 973, 572, 194, 383, 630, 395, 901, 992, 973, 938, 609, 938, 382, 169, 707, 680, 965, 726, 726, 890, 383, 172, 102, 10, 308, 10, 102, 587, 809, 460, 379, 713, 890, 463, 108, 108, 811, 176, 169, 313, 886, 400, 319, 22, 885, 572, 64, 120, 619, 313, 3, 460, 713, 811, 965, 479, 3, 247, 886, 120, 707, 120, 176, 374, 609, 395, 811, 406, 809, 801, 554, 3, 194, 11, 587, 169, 215, 313, 319, 554, 379, 788, 194, 630, 601, 965, 417, 788, 479, 64, 22, 22, 489, 166, 938, 66, 801, 374, 66, 619, 489, 215, 584, 383, 66, 680, 395, 400, 166, 572, 11, 992 };
        System.out.println(singleNumber(A));
    }
    public static int singleNumber(final int[] arr) {
        int ones = 0, twos = 0 ;
        int common_bit_mask;
        // Let us take the example of {3, 3, 2, 3} to understand this
        for (int value : arr) {
        /* The expression "one & arr[i]" gives the bits that are
        there in both 'ones' and new element from arr[]. We
        add these bits to 'twos' using bitwise OR

        Value of 'twos' will be set as 0, 3, 3 and 1 after 1st,
        2nd, 3rd and 4th iterations respectively */
            twos = twos | (ones & value);


        /* XOR the new bits with previous 'ones' to get all bits
        appearing odd number of times

        Value of 'ones' will be set as 3, 0, 2 and 3 after 1st,
        2nd, 3rd and 4th iterations respectively */
            ones = ones ^ value;


        /* The common bits are those bits which appear third time
        So these bits should not be there in both 'ones' and 'twos'.
        common_bit_mask contains all these bits as 0, so that the bits can
        be removed from 'ones' and 'twos'

        Value of 'common_bit_mask' will be set as 00, 00, 01 and 10
        after 1st, 2nd, 3rd and 4th iterations respectively */
            common_bit_mask = ~(ones & twos);


        /* Remove common bits (the bits that appear third time) from 'ones'

        Value of 'ones' will be set as 3, 0, 0 and 2 after 1st,
        2nd, 3rd and 4th iterations respectively */
            ones &= common_bit_mask;


        /* Remove common bits (the bits that appear third time) from 'twos'

        Value of 'twos' will be set as 0, 3, 1 and 0 after 1st,
        2nd, 3rd and 4th itearations respectively */
            twos &= common_bit_mask;

            // uncomment this code to see intermediate values
            //printf (" %d %d n", ones, twos);
        }

        return ones;
    }
}
