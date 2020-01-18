/*
Given an array of strings, return all groups of strings that are anagrams.
Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
Note: All inputs will be in lower-case.
Example :
Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4.
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).
Ordering of the result : You should not change the relative ordering of the words / phrases within the group.
Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.

Note:
	1. You do not need to use LinkedHashMap here. It is because the relative ordering 'within' each group is considered.
	   As we are moving sequentially, its better to use HashMap as it is faster.
	2. No it's not required. get returns a reference to the list stored in the map.
	   So whatever modification you do on the list obtained with get (add, remove...) will be reflected on the list in the map too,
	   because they are the same object. Hence, no need to remove the element, add an element and put it back to the map.
	3. It is a known fact that one should declare an object as interface type and not any specific implementation type.
	   It prevents code that uses those objects from depending on methods of those objects it doesn't need,
	   which makes the code less coupled, and therefore easier to change.
	   For example, if you find out later you really need a LinkedHashMap, you can safely make that change without affecting any other code.
	4. However, there's a trade off, because you're artificially limiting the code that can take your object as a parameter.
	   Say there's a function somewhere that requires a HashMap for some reason.
	   If you return a Map, you can't pass your object into that function.
	   You have to balance the likelihood of sometime in the future needing the extra functionality that's in the more concrete class
	   with the desire to limit coupling and keep your public interface as small as possible.
My Solution: */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnagramGroups {
    public static void main(String[] args) {
        String[] ip = {"cat","dog","tca","god","act","good"};
        Map<String, ArrayList<Integer>> res;
        res = Anagram(ip);
        System.out.println("\n\nLocations of anagrams groups are: "+res.values().toString());
    }

    private static Map<String, ArrayList<Integer>> Anagram(String[] ip) {
        int len = ip.length;
        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
        String str = null;
        for(int i =0; i < len; i++){
            str = getStringAscending(ip[i]);
            System.out.println("Str:  "+str);
            if(!map.containsKey(str)){
                System.out.println("Block 1:  "+i);
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i+1);
                map.put(str, indices);
            }else {
                System.out.println("Block 2:  "+i);
                ArrayList<Integer> indices = map.get(str);
                indices.add(i+1);
                //map.remove(str);
                map.put(str, indices);
            }
            System.out.println("Map after "+i+"th iteration is"+map.toString());
        }
        return map;
    }

    private static String getStringAscending(String s) {
        char[] c= s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}
