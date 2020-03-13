/*  Given an array of strings, return all groups of strings that are anagrams.
    Represent a group by a list of integers representing the index in the original list.
    Look at the sample case for clarification.

    Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
    Note: All inputs will be in lower-case.

    Example :
    Input : cat dog god tca
    Output : [[1, 4], [2, 3]]

    cat and tca are anagrams which correspond to index 1 and 4. dog and god are another set of anagrams which correspond to index 2 and 3. The indices are 1 based ( the first element has index 1 instead of index 0).
     Ordering of the result : You should not change the relative ordering of the words / phrases within the group. Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.

 */
package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        str.add("cat");
        str.add("god");
        str.add("dog");
        str.add("tca");
        System.out.println(anagrams(str));
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        for(int i =0; i < A.size(); i++){
            String[] temp = A.get(i).trim().split("");
            Arrays.sort(temp);
            StringBuilder key = new StringBuilder();
            for(String t : temp){
                key.append(t);
            }
//            System.out.println("KEY = "+key.toString());
            ArrayList<Integer> savedVal = hm.getOrDefault(key.toString(), null);
            if(savedVal == null){
                savedVal = new ArrayList<>();
            }
            savedVal.add(i+1);
            hm.put(key.toString(), savedVal);
        }

//        System.out.println(hm);
        return new ArrayList<>(hm.values());
    }
}
