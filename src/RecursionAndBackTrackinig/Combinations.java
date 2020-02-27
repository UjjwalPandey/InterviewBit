/*  Combinations

    Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
    Make sure the combinations are sorted. To elaborate,
        Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
    Entries should be sorted within themselves.

    Example : If n = 4 and k = 2, a solution is:
    [
      [1,2],
      [1,3],
      [1,4],
      [2,3],
      [2,4],
      [3,4],
    ]
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
        System.out.println(combine(6,3));
    }

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (A <= 0 || A < B)
            return result;
        ArrayList<Integer> item = new ArrayList<>();
        recursiveCombination(A,B,0,1,item, result);
        return result;
    }

    private static void recursiveCombination(int a, int b, int count, int curr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> results) {
//         System.out.println(a+"  "+ b+"   "+count+"   "+curr+"  "+list);
        if(count == b){
            results.add(new ArrayList<>(list));
            return;
        }
        for(int i=curr; i<= a ; i++){
            list.add(i);
            recursiveCombination(a,b,++count, ++curr, list, results);
            list.remove(list.size()-1);
            count--;
        }
    }
}
