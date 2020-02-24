/* Given a collection of numbers, return all possible permutations.
    Example: [1,2,3] will have the following permutations:
        [1,2,3]
        [1,3,2]
        [2,1,3]
        [2,3,1]
        [3,1,2]
        [3,2,1]
     NOTE
    No two entries in the permutation sequence should be the same.
    For the purpose of this problem, assume that all the numbers in the collection are unique.
    Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    Example : next_permutations in C++ / itertools.permutations in python.
 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<>();
        ip.add(1);
        ip.add(2);
        ip.add(3);
        ip.add(4);
        ArrayList<ArrayList<Integer>> res = permute(ip);
        System.out.print(res);
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
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
            ArrayList<ArrayList<Integer>> perm = permute(remaining);
            for (ArrayList<Integer> integers : perm) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(num);
                temp.addAll(integers);
                res.add(temp);
            }
        }
        return res;
    }
}
