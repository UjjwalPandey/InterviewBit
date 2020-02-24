/*
    Given a set of distinct integers, S, return all possible subsets. Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    Also, the subsets should be sorted in ascending ( lexicographic ) order.
    The list is not necessarily sorted.


    Problem Constraints
    1 <= |S| <= 16
    INTMIN <= S[i] <= INTMAX


    Input Format
    First and only argument of input contains a single integer array S.


    Output Format
    Return a vector of vectors denoting the answer.


    Example Input
    S = [1, 2, 3]


    Example Output
    [ [], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3], ]


    Example Explanation
    You can see that these are all possible subsets.
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(15);
        ip.add(20);
        ip.add(12);
        ip.add(19);
        ip.add(4);
        ArrayList<ArrayList<Integer>> res = subsets(ip);
        System.out.print(res);
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A.size() == 0){
            ArrayList<Integer> empty = new ArrayList<>();
            res.add(empty);
            return res;
        }

        int val = A.get(0);
        ArrayList<ArrayList<Integer>> thisSet = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        ArrayList<Integer> thisList = new ArrayList<>();
        thisSet.add(empty);
        thisList.add(val);
        thisSet.add(thisList);
        if(A.size() == 1){
            return thisSet;
        }

        ArrayList<ArrayList<Integer>> subset = subsets(new ArrayList<>(A.subList(1,A.size())));

        for (ArrayList<Integer> thisset : thisSet) {
            for (ArrayList<Integer>  sub: subset) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(thisset);
                temp.addAll(sub);
                res.add(temp);
            }
        }

        res.forEach(Collections::sort);
        res.remove(empty);

        res.sort((listOne, listTwo) -> {
            int oneSize = listOne.size();
            int twoSize = listTwo.size();

            for (int i = 0; i < oneSize; i++) {
                if (i == twoSize)
                    return oneSize - twoSize;

                int elementOne = listOne.get(i);
                int elementTwo = listTwo.get(i);
                if (elementOne == elementTwo)
                    continue;

                return Integer.compare(elementOne, elementTwo);
            }
            return 0;
        });

        ArrayList<ArrayList<Integer>> sorted = new ArrayList<>();
        sorted.add(empty);
        sorted.addAll(res.subList(0,res.size()));
        return sorted;
    }
}
