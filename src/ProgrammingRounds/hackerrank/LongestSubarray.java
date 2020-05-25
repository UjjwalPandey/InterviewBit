//  https://www.hackerrank.com/certificates/39a1e3d6cb9d
package ProgrammingRounds.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubarray {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(3);
        l.add(3);
        l.add(2);
        l.add(2);
        System.out.println(longestSubarray(l));  // 4
        l = new ArrayList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(longestSubarray(l));  // 4
    }

    public static int longestSubarray(List<Integer> arr) {
        int slow =0, fast =0, res =0;
        int N = arr.size();
        Set<Integer> set = new HashSet<>();
        while (fast < N && slow < N){
            if((Math.abs(arr.get(slow) - arr.get(fast)) <= 1)&& (set.size() < 2)){
                set.add(arr.get(fast));
                fast++;
                res = Math.max(res, fast - slow);
            }else if(set.size() == 2 && set.contains(arr.get(fast))){
                fast++;
                res = Math.max(res, fast - slow);
            }else {
                set.clear();
                slow++;
                fast = slow;
            }
        }
        return res;
    }
}
