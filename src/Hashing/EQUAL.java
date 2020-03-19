/*  Equal
    Given an array A of integers, find the index of values that satisfy A + B = C + D,
    where A,B,C & D are integers values in the array Note:

    1) Return the indices `A1 B1 C1 D1`, so that
      A[A1] + A[B1] = A[C1] + A[D1]
      A1 < B1, C1 < D1
      A1 < C1, B1 != D1, B1 != C1

    2) If there are more than one solutions,
       then return the tuple of values which are lexicographical smallest.

    Assume we have two solutions
    S1 : A1 B1 C1 D1 ( these are values of indices int the array )
    S2 : A2 B2 C2 D2

    S1 is lexicographically smaller than S2 iff
      A1 < A2 OR
      A1 = A2 AND B1 < B2 OR
      A1 = A2 AND B1 = B2 AND C1 < C2 OR
      A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
    Example:
    Input: [3, 4, 7, 1, 2, 9, 8]
    Output: [0, 2, 3, 5] (O index)
    If no solution is possible, return an empty list.

 */
package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EQUAL {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(4);
        A.add(7);
        A.add(1);
        A.add(2);
        A.add(9);
        A.add(8);
        System.out.println(equal(A));

        ArrayList<Integer> B = new ArrayList<>();
        B.add(9); B.add(5); B.add(4);
        B.add(9); B.add(3); B.add(6);
        B.add(8);B.add(7);B.add(1);
        B.add(2);B.add(8);B.add(7);
        B.add(2); B.add(9); B.add(7);
        B.add(1);B.add(3);B.add(9);B.add(7);
        B.add(8);B.add(1);B.add(0);B.add(5);B.add(5);
        System.out.println(equal(B));
    }

    static class pair{
        int first, second;
        pair(int f,int s)
        {
            first = f; second = s;
        }
    };

    public static ArrayList<Integer> equal(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<Integer,pair> map = new HashMap<Integer,pair>();
        int n = arr.size();

        // Traverse through all possible pairs of arr[]
        for (int i=0; i<n; ++i){
            for (int j=i+1; j<n; ++j){
                // If sum of current pair is not in hash,
                // then store it and continue to next pair
                int sum = arr.get(i)+arr.get(j);
                if (!map.containsKey(sum)) {
                    map.put(sum, new pair(i, j));
                }else {
                    // Else (Sum already present in hash){
                    // Find previous pair
                    pair p = map.get(sum);
                    // Since array elements are distinct, we don't
                    // need to check if any element is common among pairs
                    HashSet<Integer> hs = new HashSet<>();
                    if((p.first != i) && (p.second != j) && (p.second != i) && (p.first != j)) {
                        ArrayList<Integer> tuple = new ArrayList<>();
                        tuple.add(p.first);
                        tuple.add(p.second);
                        tuple.add(i);
                        tuple.add(j);
                        res.add(tuple);
                    }
                }
            }
        }

        res.sort((t1,t2 )  -> {
            int t1_1 = t1.get(0);
            int t2_1 = t2.get(0);
            if(t1_1 == t2_1) {
                int t1_2 = t1.get(1);
                int t2_2 = t2.get(1);

                if(t1_2 == t2_2) {
                    int t1_3 = t1.get(2);
                    int t2_3 = t2.get(2);

                    if(t1_3 == t2_3) {
                        int t1_4 = t1.get(3);
                        int t2_4 = t2.get(3);
                        return Integer.compare(t1_4, t2_4);
                    }else{
                        return Integer.compare(t1_3, t2_3);
                    }
                }else{
                    return Integer.compare(t1_2, t2_2);
                }
            }else{
                return Integer.compare(t1_1, t2_1);
            }

        });

        return res.get(0);
    }
}
