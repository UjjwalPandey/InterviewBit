/* Given a collection of numbers that might contain duplicates, return all possible unique permutations. Example : [1,1,2] have the following unique permutations:
    [1,1,2]
    [1,2,1]
    [2,1,1]

    NOTE : No 2 entries in the permutation sequence should be the same.
    Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    Example : next_permutations in C++ / itertools.permutations in python.
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.HashSet;

public class AllUniquePermutations {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(1);
        ip.add(2);
        ip.add(1);
        ArrayList<ArrayList<Integer>> res = uniquePermute(ip);
        System.out.print(res);
    }

    public static ArrayList<ArrayList<Integer>> uniquePermute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A.size() == 1){
            res.add(A);
            return res;
        }

        for(int i=0; i< A.size(); i++){
            int num = A.get(i);
            ArrayList<Integer> remaining = new ArrayList<>();
            if(i == 0){
                remaining.addAll(A.subList(i+1,A.size()));
            }else if(i== A.size()-1){
                remaining.addAll(A.subList(0,i));
            }else{
                remaining.addAll(A.subList(0,i));
                remaining.addAll(A.subList(i+1, A.size()));
            }
            ArrayList<ArrayList<Integer>> perm = uniquePermute(remaining);
            for (ArrayList<Integer> integers : perm) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(num);
                temp.addAll(integers);
                res.add(temp);
            }
        }
        HashSet<ArrayList<Integer>> hs = new HashSet<>(res);

        return new ArrayList<>(hs);
    }
}
