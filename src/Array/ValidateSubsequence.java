/*  Validate Subsequence - https://www.algoexpert.io/questions/Validate%20Subsequence
 *
 *  Given two non-empty arrays of integers, write a function that determines whether the second array is a
 *  subsequence of the first one.
 *
 *  A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in
 *  the same order as they appear in the array. For instance, the numbers [1, 3, 4]  form a subsequence of the array
 *  [1, 2, 3, 4] , and so do the numbers [2, 4].
 *
 *  Note: that a single number in an array and the array itself are both valid subsequences of the array.
 */
package Array;

import java.util.ArrayList;
import java.util.List;

public class ValidateSubsequence {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(2);
        seq.add(4);
        System.out.println(isValidSubsequence(list, seq));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int i, j = 0;
        for(i=0; i<sequence.size();){
            while (j < array.size()) {
                if(array.get(j).equals(sequence.get(i))){
                    i++;
                    j++;
                    break;
                }else{
                    j++;
                }
            }
            if( j == array.size()) break;
        }
        return j < array.size() || i == sequence.size();
    }
}
